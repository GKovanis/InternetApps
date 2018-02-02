//ServletExample

package org.example02.test;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ServletExample extends HttpServlet{
	
	 public void doPost( HttpServletRequest req,        // reaction to the reception of GET
             HttpServletResponse resp )
             throws ServletException, IOException
             
      {      
		    Cookie cookies[];
         	cookies = req.getCookies();  // request client's side cookies
         	Cookie usernamecookie;

		 usernamecookie = new Cookie( "username" ,req.getParameter( "username") );   // to be stored as a cookie
	    	Cookie emailcookie = new Cookie( "email" ,req.getParameter( "email") );   
	    	Cookie phonecookie = new Cookie( "phone" ,req.getParameter( "phone") );   
	      	
	      	usernamecookie.setMaxAge( 1200 );  // seconds until cookie removed	  	  
	      	emailcookie.setMaxAge( 1200 );    
	      	phonecookie.setMaxAge( 1200 );  
		  
	      	resp.addCookie( usernamecookie );  // before getWriter
	      	resp.addCookie( emailcookie );  
	      	resp.addCookie( phonecookie );  
	

	//Make Icon Go to previous page
	resp.setContentType( "text/html" ); 
	resp.getWriter().println("<html>");
	resp.getWriter().println("<head>");
	resp.getWriter().println("<title>X-Port Co.</title>");
	resp.getWriter().println("<link rel='shortcut icon' href='X-Port Icon.ico' />");
	resp.getWriter().println("</head>");
	resp.getWriter().println("<link rel='stylesheet' type='text/css' href='webstyle.css' media='screen'/>");
	resp.getWriter().println("<body>");
	resp.getWriter().println("<div class=\"container\">");
	resp.getWriter().println("<Header>");
	resp.getWriter().println("<a href=\"http://localhost:8080/Example02\">");
	resp.getWriter().println("<img src='X-Port Logo Final.png'  style='width:353px;height:168px;'>");
	resp.getWriter().println("</a>");
	resp.getWriter().println("</Header>");
	resp.getWriter().println("<script type='text/javascript'>"); //java script that enables us to "go back" one page
  	resp.getWriter().println("function goBack()");
  	resp.getWriter().println("{");
  	resp.getWriter().println("window.history.go(-1)");
  	resp.getWriter().println("}");
  	resp.getWriter().println("</script>");
	
	resp.getWriter().println("<arcticle>");
	resp.getWriter().println("<div align=\"right\">");
	resp.getWriter().println("&emsp;&emsp;");
	resp.getWriter().println("<fieldset >");
	// Welcome Bar
	resp.getWriter().println("<div id=\"username\" align=\"center\">");
	resp.getWriter().println("Welcome " + usernamecookie.getValue());
	resp.getWriter().println("</div>");
	resp.getWriter().println("</div>");
	resp.getWriter().println("</fieldset>");
	//Side Bar
	resp.getWriter().println("<nav>");
	resp.getWriter().println("<b>Enroll to our Newsletter</b>");
	resp.getWriter().println("<input type=\"text\" placeholder='Enter Your E-mail' name=\"ename\"></br>");
	resp.getWriter().println("</br>");
	resp.getWriter().println("<li><a href=\"http://localhost:8080/Example02\"><b>Home</b></a></li>");
	resp.getWriter().println("<li><a href=\"http://localhost:8080/Example02/AboutUs.html\"><b>About X-Port</b></a></li>");
	resp.getWriter().println("<li><a href=\"http://localhost:8080/Example02/ContactUs.html\"><b>Contact Us</b></a></li>");
	resp.getWriter().println("</nav>");
	
	resp.getWriter().println("</br></br></br></br></br></br></br></br></br></br></br></br></br>");
	//Types of PC: Desktop, Laptop and Gaming PC
	resp.getWriter().println("<div align='center' style='width:100%; overflow:auto; align:center'>");
	resp.getWriter().println("&nbsp;&emsp;&nbsp;&nbsp;&emsp;&emsp;");
	resp.getWriter().println("<b><font size=\"5\"> Desktop </font></b>");
	resp.getWriter().println("&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;");
	resp.getWriter().println("<b><font size=\"5\">Laptop</font></b>");
	resp.getWriter().println("&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;");
	resp.getWriter().println("<b><font size=\"5\">Gaming PC</font></b>");
	resp.getWriter().println("</div>");
	// Pictures of PC types
	resp.getWriter().println("<div align='center' style='width:100%; background-color:white; height:150px;overflow:auto;'>");
	resp.getWriter().println("&emsp;&emsp;&emsp;&nbsp;&nbsp;");
	resp.getWriter().println(" <img  src='desktop.png' alt scr='Mountain View' width='270' height='140'/>");
	resp.getWriter().println("<img src='laptop.jpg' alt scr='Mountain View' width='270' height='120'>");	
	resp.getWriter().println("<img src='gamingpc.png' alt scr='Mountain View' width='270' height='120'/>");
	resp.getWriter().println("</div>");
	
	resp.getWriter().println("<div align='center' style='width:100%; background-color:white; height:150px;overflow:auto;'>");

	// Buttons to choose specific PC (give parameter "buy" to what the user chooses so we can use it next servlet to go to the appropriate category)
	// Using POST method to hide the values in the URL
	resp.getWriter().println("<form id='login' action='servlet2' method='POST'>");
	resp.getWriter().println("&emsp;&emsp;&emsp;&emsp;");
	resp.getWriter().println("<input type='Submit' value='Desktop' name='Buy' id='Desktop' />");
	resp.getWriter().println("<form id='login' action='servlet2' method='POST'>");
	resp.getWriter().println("&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;");
	resp.getWriter().println("<input type='Submit' value='Laptop' name='Buy' id='Laptop' />");
	resp.getWriter().println("<form id='login' action='servlet2' method='POST'>");
	resp.getWriter().println("&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;");
	resp.getWriter().println("<input type='Submit' value='GamingPC' name='Buy' id='GamingPC' />");
	resp.getWriter().println("</div>");
    resp.getWriter().println(" </br>");
    resp.getWriter().println(" </br>");
    resp.getWriter().println(" </br>");
  
    
	
	resp.getWriter().println("</article>");
	//footer
	resp.getWriter().println("<div>");
	resp.getWriter().println("<footer>Copyright &copy; X-Port</footer>");
	resp.getWriter().println("</div>");
	resp.getWriter().println("</body>");
	resp.getWriter().println("</html>");
   	}
   	
}
