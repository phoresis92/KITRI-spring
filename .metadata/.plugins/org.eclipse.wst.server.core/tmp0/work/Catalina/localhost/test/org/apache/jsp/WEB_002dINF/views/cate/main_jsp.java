/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-01-31 06:37:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.cate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1548377033159L));
    _jspx_dependants.put("jar:file:/C:/Users/hushe/Desktop/SPRING/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/springWeb2/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("/* function getM(){\r\n");
      out.write("var param = \"parent=\"+$('#large').val();\r\n");
      out.write("//console.log(param);\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\ttype: 'get',\r\n");
      out.write("\t\turl: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/cate/cate2',\r\n");
      out.write("\t\tdata: param,\r\n");
      out.write("\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t$('#medium').empty();\r\n");
      out.write("\t\t\t$('#small').empty();\r\n");
      out.write("\t\t\tvar list = JSON.parse(data);\r\n");
      out.write("\t\t\t//console.log(list);\r\n");
      out.write("\t\t\t$('<select id=\"medi\"></select>').attr('onchange','getS()').appendTo('#medium');\r\n");
      out.write("\t\t\t$('<option disabled selected >중분류</option>').appendTo('#medi');\r\n");
      out.write("\t\t\tfor(var i in list){\r\n");
      out.write("\t\t\t\t$('<option></option>').val(list[i].num).text(list[i].name).appendTo('#medi');\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})//ajax end\r\n");
      out.write("}//getM end\r\n");
      out.write("\r\n");
      out.write("function getS(){\r\n");
      out.write("\tvar param = \"parent=\"+$('#medi').val();\r\n");
      out.write("\t//console.log(param);\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\ttype: 'get',\r\n");
      out.write("\t\turl: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/cate/cate2',\r\n");
      out.write("\t\tdata: param,\r\n");
      out.write("\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t$('#small').empty();\r\n");
      out.write("\t\t\tvar list = eval(data);\r\n");
      out.write("\t\t\t//console.log(list);\r\n");
      out.write("\t\t\t$('<select id=\"sm\"></select>').appendTo('#small');\r\n");
      out.write("\t\t\t$('<option disabled selected >소분류</option>').appendTo('#sm');\r\n");
      out.write("\t\t\tfor(var i in list){\r\n");
      out.write("\t\t\t\t$('<option></option>').val(list[i].num).text(list[i].name).appendTo('#sm');\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})//ajax end\r\n");
      out.write("}//getS end */\r\n");
      out.write("\r\n");
      out.write("/* $(document).ready(function(){\r\n");
      out.write("\t$('option').first().on('click', getM());\r\n");
      out.write("}) */\r\n");
      out.write("\r\n");
      out.write("$.makeSelect=function(arr, id){\r\n");
      out.write("\tvar new_id = \"\";\r\n");
      out.write("\tvar s_name = \"\";\r\n");
      out.write("\tvar title = \"\";\r\n");
      out.write("\tif(id == \"large\"){\r\n");
      out.write("\t\tnew_id = \"medium\";\r\n");
      out.write("\t\ts_name = \"#s2\";\r\n");
      out.write("\t\t//$(s_name).html('')\r\n");
      out.write("\t\t$('#small').html('');\r\n");
      out.write("\t\ttitle = '중분류';\r\n");
      out.write("\t}else if(id == \"medium\"){\r\n");
      out.write("\t\tnew_id = \"small\";\r\n");
      out.write("\t\ts_name = \"#s3\";\r\n");
      out.write("\t\ttitle = '소분류';\r\n");
      out.write("\t}\r\n");
      out.write("\tvar str = \"<select class='cate' id='\"+new_id+\"'>\";\r\n");
      out.write("\tstr += \"<option selected disabled>\"+title+\"</option>\"\r\n");
      out.write("\tfor(i=0; i< arr.length; i++){\r\n");
      out.write("\t\tstr += \"<option value=\"+arr[i].num+\">\"+arr[i].name+\"</option>\";\r\n");
      out.write("\t}\r\n");
      out.write("\tstr += \"</select>\";\r\n");
      out.write("\tconsole.log(new_id)\r\n");
      out.write("\tconsole.log(str)\r\n");
      out.write("\t//$(s_name).html(str)\r\n");
      out.write("\t$('#'+new_id+'').html(str);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t$(document).on('change','.cate',function(){\r\n");
      out.write("\t\tvar id = $(this).attr('id');\r\n");
      out.write("\t\tvar parent = $(this).val();\r\n");
      out.write("\t\tconsole.log(id, parent)\r\n");
      out.write("\t\tif(id != \"small\"){\r\n");
      out.write("\t\t\tvar param = \"parent=\"+parent;\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype: 'post',\r\n");
      out.write("\t\t\t\turl: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/cate/cate2',\r\n");
      out.write("\t\t\t\tdata: param,\r\n");
      out.write("\t\t\t\tsuccess: function(data){\r\n");
      out.write("\t\t\t\t\tvar arr = eval('('+data+')');\r\n");
      out.write("\t\t\t\t\tconsole.log(arr)\r\n");
      out.write("\t\t\t\t\t$.makeSelect(arr, id);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})//ajax end\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})// on end\r\n");
      out.write("})//ready end\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t\t<select class=\"cate\" id=\"large\" name=\"type\" >\r\n");
      out.write("\t\t<option selected disabled >대분류</option>\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</select>\r\n");
      out.write("\r\n");
      out.write("<div  id=\"medium\"></div>\r\n");
      out.write("<div  id=\"small\"></div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/cate/main.jsp(114,1) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("SearchType");
      // /WEB-INF/views/cate/main.jsp(114,1) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/cate/main.jsp(114,1) '${ LargeTypeList }'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${ LargeTypeList }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\r\n");
            out.write("\t<option value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ SearchType.code }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write(' ');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ SearchType.text }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</option>\r\n");
            out.write("\t\r\n");
            out.write("\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}