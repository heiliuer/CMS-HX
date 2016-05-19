package com.hx.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.hx.utils.Status;

@WebServlet("/file")
public class FileServlet extends ServletBase {
	private static final String FILES = "files";
	private static final long serialVersionUID = 1L;

	public FileServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 设置编码

		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取文件需要上传到的路径
		String path = request.getServletContext().getRealPath(FILES);
		new File(path, "test").mkdirs();

		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(path));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);

		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// 可以上传多个文件
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);

			for (FileItem item : list) {
				// 获取表单的属性名字
				String fieldName = item.getFieldName();

				// 如果获取的 表单信息是普通的 文本 信息
				if (item.isFormField()) {
					// 获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的
					// String value = item.getString();
					// System.out.println("简单参数-" + name + ":" + value);
				}
				// 对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
				else {
					/**
					 * 以下三步，主要获取 上传文件的名字
					 */
					// 获取路径名
					String fileName = item.getName();
					System.out.println("文件-" + fieldName + ":" + fileName);

					// 真正写到磁盘上
					// 它抛出的异常 用exception 捕捉

					// item.write( new File(path,filename) );//第三方提供的

					// 手动写的
					String saveFileName = UUID.randomUUID().toString() + getSuffix(fileName);
					OutputStream out = new FileOutputStream(new File(path, saveFileName));

					InputStream in = item.getInputStream();

					int length = 0;
					byte[] buf = new byte[1024];

					System.out.println("获取上传文件的总共的容量：" + item.getSize());
					System.out.println("写文件 " + new File(path, saveFileName).getAbsolutePath());
					// in.read(buf) 每次读到的数据存放在 buf 数组中
					while ((length = in.read(buf)) != -1) {
						// 在 buf 数组中 取出数据 写到 （输出流）磁盘上
						out.write(buf, 0, length);

					}
					in.close();
					out.close();
					toJson(response, new Status(0, ImmutableMap.of("path", FILES + File.separator + saveFileName)));
					return;
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 原生servlet解析文件，没有test成功
	protected void doGet1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new Gson().toJson(request.getParameterMap()));
		String suffix = getSuffix(request.getParameter("filename"));
		try {
			System.out.println("filename:" + getParameter(request, "filename"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		InputStream in = request.getInputStream();
		File f = new File(request.getServletContext().getRealPath("") + File.separator + FILES,
				UUID.randomUUID().toString() + suffix);
		System.out.println(f.getAbsolutePath());
		FileOutputStream fos = new FileOutputStream(f);
		byte[] b = new byte[1024];
		int n = 0;
		while ((n = in.read(b)) != -1) {
			fos.write(b, 0, n);
		}
		fos.close();
		in.close();
	}

	private String getSuffix(String fileName) {
		int dotIndex = fileName.lastIndexOf('.');
		if (dotIndex == -1)
			return "";
		return fileName.substring(dotIndex, fileName.length());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String getParameter(HttpServletRequest req, String name) throws Exception {
		String retValue = null;
		Part part = req.getPart(name);
		BufferedReader br = new BufferedReader(new InputStreamReader(part.getInputStream()));
		retValue = br.readLine();// 读取请求参数值

		return retValue;
	}

}
