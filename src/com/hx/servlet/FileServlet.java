package com.hx.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/file")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String suffix = getSuffix(request.getParameter("filename"));
		InputStream in = request.getInputStream();
		File f = new File(request.getServletContext().getRealPath("") + File.separator + "files",
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

}
