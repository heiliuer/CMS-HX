/*按钮之类的提交时disabled, 然后提交完成自动enable; 用在提交动作发生前, 如 onsubmit 中
用法举例： 参见本目录formfuncdemo.htm
*/
function VsbFormFunc()
{
    var _this = this;
    _this.disableAutoEnable = function(o)
    {
        o.disabled=true;
        setTimeout(function(){_this.enableOnComplete(o);}, 500);
    }
    
    _this.enableOnComplete = function(o)
    {
       if(window.document.readyState=='complete')
       {
          o.disabled = false;
       }
       else
       {
           setTimeout(function(){_this.enableOnComplete(o);}, 500);
       }
    }        
};
