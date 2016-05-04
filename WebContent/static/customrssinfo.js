   
function rssGetInfo()
{
    var _this = this;
    var formname = "";
    var choiceotherinfo = "";
    var waitinfo = "";
    
    var _xmlhttp = createXMLHttpRequest();

    var _titlestyle = "";
    var titleshow = "";
    var imageshow = "";
    var newsshow = "";
    var linkmode = "";
    
    var _number = "";

    var _newstitlestyle = "";
    var _contentstyle = "";
    var _timestyle = "";
    var _leaderfont = "";
    var _leader = "";
    var _endimage = "";
    var _titlelen = "";
    var _endimagenumber = "";
    var _categoryshow = "";
    var timeshow = "";
    
    var _timeformat = "";
    var _newsclassname = "";
    var _dateyear = "";
    var _datemonth = "";
    var _dateday = "";
    var _datehour = "";
    var _datecent = "";
    var _datesecond = "";
    var _tdunderline = "";
    _this._initrss = function(_formname,_choiceotherinfo,_waitinfo,titlestyle,_titleshow,_imageshow,_newsshow,_linkmode,number_n,newstitlestyle,contentstyle,timestyle,leaderfont,leader,endimage,titlelen,endimagenumber,categoryshow,timeformat,newsclassname,dateyear,datemonth,dateday,datehour,datecent,datesecond,tdunderline)
    {
        formname = _formname;
        choiceotherinfo = _choiceotherinfo;
        waitinfo = _waitinfo;
    
        _titlestyle = titlestyle;
        titleshow = _titleshow;
        imageshow = _imageshow;
        newsshow = _newsshow;
        linkmode = _linkmode;
        
        _number = number_n;
    
        _newstitlestyle = newstitlestyle;
        _contentstyle = contentstyle;
        _timestyle = timestyle;
        _leaderfont = leaderfont;
        _leader = leader;
        _endimage = endimage;
        _titlelen = titlelen;
        _endimagenumber = endimagenumber;
        _categoryshow = categoryshow;
        _timeformat = timeformat;
        _newsclassname = newsclassname;
        _dateyear = dateyear;
        _datemonth = datemonth;
        _dateday = dateday;
        _datehour = datehour;
        _datecent = datecent;
        _datesecond = datesecond;
        _tdunderline = tdunderline;
    }
    _this._onget = function()  
    {
        if(_xmlhttp.readyState == 4)
        {
            if(_xmlhttp.status == 200)
            {
                try
                {
                    _this._feedlist();
                }
                catch(e)
                {
                    document.getElementById(formname+'title').innerHTML=choiceotherinfo;
                }
            }
            else
            {
                document.getElementById(formname+'title').innerHTML=choiceotherinfo;
            }
        }
    }
        
    _this._getRss = function(url)
    {
        document.getElementById(formname+'title').innerHTML=waitinfo;
        document.getElementById(formname+'image').innerHTML="";
        var tb = document.getElementById(formname+'message');
        for(var i = tb.rows.length - 1; i >=0 ; i--)
        {
            tb.rows[i].removeNode(true);
        }
        startRequest(url, _this._onget,_xmlhttp);
    }
    
    _this._feedlist = function()
    {
        var  _xmldoc  =  _xmlhttp.responseXML;  
        
        //channel
        var _xmlchannel = getXmlChild(_xmldoc, "channel");
        var _xmlctitle = getXmlData(_xmlchannel, "title");
        var _xmlcdescription = getXmlData(_xmlchannel, "description", "");

        var _xmlclink = getXmlData(_xmlchannel, "link");
        if(titleshow == "true")
            document.getElementById(formname+'title').innerHTML  =  "<a href=\"" + escapeForValue(_xmlclink) + "\" "+formname+"title=\"" + escapeForValue(_xmlcdescription) + "\"  "+linkmode+" "+_titlestyle+">" + _xmlctitle + "</a>";
        else
            document.getElementById(formname+'title').innerHTML = "";
    
        //img 文章频道的图标
        var _xmlimage = getXmlChild(_xmlchannel, "image");
        
        if(imageshow == "true")
        {
            if(_xmlimage != null)
            {
                var _imgtitle = getXmlData(_xmlimage, "title");
                var _imglink = getXmlData(_xmlimage, "link");
                var _imgurl = getXmlData(_xmlimage, "url");
                document.getElementById(formname+'image').innerHTML  =  "<a href=\"" + escapeForValue(_imglink) + "\" "+linkmode+"><img border=0 src=\"" + escapeForValue(_imgurl) + "\" "+formname+"title=\"" + escapeForValue(_imgtitle) + "\"></a>";
            }
        }
        else
            document.getElementById(formname+'image').innerHTML = "";
    
        var _items = _xmldoc.getElementsByTagName("item");
        var _newsshow = "";
        
        if(newsshow == "true")
            _newsshow = null;
                     
        if(_number>_items.length ||_number=="") 
        {
            _number=_items.length;
        }
        
                                         
        for(i=0;i<_number;i++)
        {//显示文章内容
            var _itemtitle = getXmlData(_items[i], "title");
            var _itemlink = getXmlData(_items[i], "link");
            var _itemdescription = getXmlData(_items[i], "description", "");
            var _itemcategory = getXmlData(_items[i], "category", null);
            var itempubDate = getXmlData(_items[i], "pubDate", "");
            //控制文章标题的长度
            var _itemtitletemp=_itemtitle;
            _itemtitle = _this._fixtitlelen(_itemtitle, _titlelen * 2);
            var _itempubYear = "";
            var _itempubMonth = "";
            var _itempubDate = "";
            var _itempubHours = "";
            var _itempubMinutes = "";
            var _itempubSeconds = "";
            //获取日期
            try
            {
                itempubDate=itempubDate.replace("-","//");   
                var _itemDates = new Date(itempubDate);
                if(!isNaN(_itemDates))
                {
                    var _itemYear = _itemDates.getYear();
                    var _itemMonth = _itemDates.getMonth()+1;
                    var _itemDate = _itemDates.getDate();
                    var _itemHours = _itemDates.getHours();
                    var _itemMinutes = _itemDates.getMinutes();
                    var _itemSeconds = _itemDates.getSeconds();
                    if(!isNaN(_itemYear))
                        _itempubYear = _itemYear.toLocaleString().substring(0,1) + _itemYear.toLocaleString().substring(2,5);
                    if(!isNaN(_itemMonth))
                        _itempubMonth = _itemMonth.toLocaleString().substring(0,_itemMonth.toLocaleString().indexOf(".")==-1?_itemMonth.toLocaleString().length:_itemMonth.toLocaleString().indexOf("."));
                    if(!isNaN(_itemDate))
                        _itempubDate = _itemDate.toLocaleString().substring(0,_itemDate.toLocaleString().indexOf(".")==-1?_itemDate.toLocaleString().length:_itemDate.toLocaleString().indexOf("."));
                    if(!isNaN(_itemHours))
                        _itempubHours = _itemHours.toLocaleString().substring(0,_itemHours.toLocaleString().indexOf(".")==-1?_itemHours.toLocaleString().length:_itemHours.toLocaleString().indexOf("."));
                    if(!isNaN(_itemMinutes))
                        _itempubMinutes = _itemMinutes.toLocaleString().substring(0,_itemMinutes.toLocaleString().indexOf(".")==-1?_itemMinutes.toLocaleString().length:_itemMinutes.toLocaleString().indexOf("."));
                    if(!isNaN(_itemSeconds))
                    {
                        _itempubSeconds = _itemSeconds.toLocaleString().substring(0,_itemSeconds.toLocaleString().indexOf(".")==-1?_itemSeconds.toLocaleString().length:_itemSeconds.toLocaleString().indexOf("."));
                        if(_itempubSeconds == "")
                            _itempubSeconds = 0;
                    }
                }
            }
            catch(e)
            {
            }
            var _itempubDates = "";
            var _timeshow = "";
            if(!isNaN(_itemDates))
            {
                if(_timeformat == 0)
                    _timeshow==null;
                if(_timeformat == 1)
                    _itempubDates = _itempubYear + _dateyear + _itempubMonth + _datemonth + _itempubDate + _dateday + _itempubHours + _datehour + _itempubMinutes + _datecent + _itempubSeconds + _datesecond;
                if(_timeformat == 2)
                    _itempubDates = _itempubYear + _dateyear + _itempubMonth + _datemonth + _itempubDate + _dateday + _itempubHours + _datehour + _itempubMinutes + _datecent;
                if(_timeformat == 3)
                    _itempubDates = _itempubYear + _dateyear + _itempubMonth + _datemonth + _itempubDate + _dateday + _itempubHours + ":" + _itempubMinutes ;
                if(_timeformat == 4)
                    _itempubDates = _itempubMonth + _datemonth + _itempubDate + _dateday + _itempubHours + ":" + _itempubMinutes ;
                if(_timeformat == 5)
                    _itempubDates = _itempubYear + _dateyear + _itempubMonth + _datemonth + _itempubDate + _dateday;
                if(_timeformat == 6)
                    _itempubDates = _itempubMonth + _datemonth + _itempubDate + _dateday;
                if(_timeformat == 7)
                    _itempubDates = _itempubYear + "-" + _itempubMonth + "-" + _itempubDate + " " + _itempubHours + ":" + _itempubMinutes + ":" + _itempubSeconds;
                if(_timeformat ==8)
                    _itempubDates = _itempubYear + "-" + _itempubMonth + "-" + _itempubDate + " " + _itempubHours + ":" + _itempubMinutes;
                if(_timeformat == 9)
                    _itempubDates = _itempubYear + "/" + _itempubMonth + "/" + _itempubDate;
                if(_timeformat == 10)
                    _itempubDates = _itempubMonth + "/" + _itempubDate + " " + _itempubHours + ":" + _itempubMinutes;
                if(_timeformat == 11)
                    _itempubDates = _itempubMonth + "/" + _itempubDate;
                if(_timeformat == 12)
                    _itempubDates = _itempubMonth + "-" + _itempubDate;
            }
            else
            {
                if(_timeformat == 0)
                    _timeshow==null;
                else
                    _itempubDates = itempubDate;
            }
            if(i >= _endimagenumber)
            {
                _endimage = null;
            }
            if(_categoryshow == "true")
            {
                _itemcategory=null;
            }
    
            var tr = document.getElementById(formname+'message').insertRow(-1);
            var td = tr.insertCell(-1);
            if(_leader != "")
            {
                td.innerHTML = "<span" + _leaderfont + " >" +_leader+ "</span>&nbsp;&nbsp;";
                td.className = _tdunderline;
                td = tr.insertCell(-1);
                td.className = _tdunderline;
            }
            td.style.cssText="font-size:9pt";
            td.height="25";
            td.innerHTML = ((_itemcategory==null)?"":("<span>[" + _itemcategory + "]</span>")) 
            + "<span title=\""+ _itemtitletemp +"\"><a href=\"" + escapeForValue(_itemlink) +"\"  "+linkmode+_newstitlestyle+ (i < 3?" style=\"color:#bd0100\"":"")+">" 
            + _itemtitle + "</a></span>"
            + ((_endimage==null)?"":("&nbsp;<span>" + _endimage + "</span>"));
            
            if(_newsshow != null)
            {
                tr = document.getElementById(formname+'message').insertRow(-1);
                if(_leader != "")
                {
                    td = tr.insertCell(-1);
                    td = tr.insertCell(-1);
                }
                td = tr.insertCell(-1);
                td.innerHTML = "<BLOCKQUOTE "+_contentstyle+">" + _itemdescription +"</BLOCKQUOTE>";
            }
            if(_timeshow != null)
            {
                var td1 = tr.insertCell(-1);
                td1.className = _tdunderline;
                td1.align = "right";
                td1.innerHTML = "<span "+_timestyle+">" + _itempubDates +"</span>";
            }
        }  
    }
    
    _this._fixtitlelen = function(str, len)
    {
        if(str.length * 2 <= len || str.length == 0 || len <= 0)
            return str;
        if(len <= 3)
            return "...";
        
        var count = 0, sublen = -1, i;
        for(i = 0; i < str.length && count < len; i++)
        {
            var size = str.charCodeAt(i) > 255 ? 2 : 1;
            count += size;
    
            if (count > len - 3 && sublen == -1)
            {
                sublen = i;
            }
        }
    
        if(i < str.length || count > len)
        {
            str = str.substr(0, sublen) + "...";
        }
        return str;
    }
}