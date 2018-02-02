package org.example02.test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ServletExample1 extends HttpServlet {
	
	private String CPU[]= {"AMD Ryzen x1600 3.00 GHz","Intel Core i5 6200U 2.40 GHz ","AMD Ryzen x1800 4.00 GHz","Intel Core i7 6700U 3.40 GHz"};
	private double CostCPU[]= {229,250,500,1000};
	private String RAM[]= {"8 GB DDR4 2133 MHz","8 GB DDR4 2600 MHz","16 GB DDR4 2133 MHz","16 GB DDR4 3200 MHz"};
	private double CostRAM[]={80,120,160,250};
	private String HardDrives[]={"256 GB SSD","500 GB SSD","1 TB HDD + 256 GB SSD","2 TB HDD + 500 GB SSD"};
	private double CostHardDrives[]={120,180,190,280};
	private String Type[] = {"Laptop","Desktop","GamingPC"};
	private double CostType[] = {300,200,400};
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	//initializing cookies' values
	String username="";
	String email="";
    String Laptop = "Laptop";
	String Desktop = "Desktop"; 
	Cookie cookies[];
	cookies = req.getCookies(); // request client side's cookies
	String Buy = req.getParameter("Buy");
	//creating new cookie for each value
	Cookie CPUcookie = new Cookie ("CPU",req.getParameter("CPU"));
    CPUcookie.setMaxAge( 1200 );  //seconds until cookie removed
  	resp.addCookie( CPUcookie );  //before GetWriter
  	
  	
  	Cookie CostCPUcookie = new Cookie ("CostCPU",req.getParameter("CostCPU"));
    CostCPUcookie.setMaxAge( 1200 );  
  	resp.addCookie( CostCPUcookie );  
  	
    
    Cookie RAMcookie = new Cookie ("RAM",req.getParameter("RAM"));
    RAMcookie.setMaxAge( 1200 );  
  	resp.addCookie( RAMcookie );  
  	
  	
    Cookie CostRAMcookie = new Cookie ("CostRAM",req.getParameter("CostRAM"));	  
    RAMcookie.setMaxAge( 1200 );  
  	resp.addCookie( CostRAMcookie );  
  	
  	
  	Cookie HardDrivescookie = new Cookie ("HardDrives",req.getParameter("HardDrives"));
    HardDrivescookie.setMaxAge( 1200 );  
  	resp.addCookie( HardDrivescookie ); 
  	
	
  	Cookie CostHardDrivescookie = new Cookie ("CostHardDrives",req.getParameter("CostHardDrives"));
    CostHardDrivescookie.setMaxAge( 1200 );  
  	resp.addCookie( CostHardDrivescookie );  

  	//Make Icon Go to previous page

	resp.setContentType( "text/html" ); 
	resp.getWriter().println("<script type='text/javascript'>");
  	resp.getWriter().println("function goBack()");
  	resp.getWriter().println("{");
  	resp.getWriter().println("window.history.go(-1)");
  	resp.getWriter().println("}");
  	resp.getWriter().println("</script>");
	resp.getWriter().println("<html>");
	resp.getWriter().println("<head>");
	resp.getWriter().println("<title>X-Port Co.</title>");
	resp.getWriter().println("<link rel='shortcut icon' href='X-Port Icon.ico' />");
	resp.getWriter().println("</head>");
	resp.getWriter().println("<link rel='stylesheet' type='text/css' href='webstyle.css' media='screen'/>");
	resp.getWriter().println("<body>");
	resp.getWriter().println("<div class=\"container\">");
	resp.getWriter().println("<Header>");
	resp.getWriter().println("<a <input type=\"image\" onclick='goBack()' name=\"X-Port Logo Final\" src=\"X-Port Logo Final.png\" >");
	resp.getWriter().println("<img src='X-Port Logo Final.png'  style='width:353px;height:168px;'>");
	resp.getWriter().println("</a>");
	resp.getWriter().println("</Header>");
	//Side Bar
	resp.getWriter().println("<nav>");
	resp.getWriter().println("<b>Enroll to our Newsletter</b>");
	resp.getWriter().println("<input type=\"text\" placeholder='Enter Your E-mail' name=\"ename\"></br>");
	resp.getWriter().println("</br>");
	resp.getWriter().println("<li><a href=\"http://localhost:8080/Example02\"><b>Home</b></a></li>");
	resp.getWriter().println("<li><a href=\"http://localhost:8080/Example02/AboutUs.html\"><b>About X-Port</b></a></li>");
	resp.getWriter().println("<li><a href=\"http://localhost:8080/Example02/ContactUs.html\"><b>Contact Us</b></a></li>");
	resp.getWriter().println("</nav>");
    resp.getWriter().println(" </br>");
    resp.getWriter().println(" </br>");
    resp.getWriter().println(" </br>");
    resp.getWriter().println(" </br>");
    resp.getWriter().println(" </br>");
	resp.getWriter().println("<arcticle>");
	resp.getWriter().println("<div align=\"right\">");
	resp.getWriter().println("&emsp;&emsp;");
	// if-statement to go to the appropriate category depending on "buy" parameter from previous servlet
 	 if ( Laptop.equals(Buy)){
		 
			Cookie TotalCostcookie = new Cookie ("TotalCost","300");
			TotalCostcookie.setMaxAge( 1200 );  
		  	resp.addCookie( TotalCostcookie );  // totalcost to add all the costs and have it available in next servlet
		 //retrieve the username and the e-mail of the client
		 for (int i=0;i<cookies.length;i++){
		 		if (cookies[i].getName().equals("username")){
					username=(cookies[i].getValue());
		 		}
		 		else if (cookies[i].getName().equals("email")){
					email=(cookies[i].getValue());
		 		}
		 }
		//name and icon of chosen product 
		resp.getWriter().println(" <div align='center' style=\"  align:center\">");
		resp.getWriter().println("<b><font size=\"6\"> Laptop </font></b>");
		resp.getWriter().println("&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;");
	    resp.getWriter().println("</div>");
	    resp.getWriter().println("<div align=\"center\" style=\" background-color:white; height:250px;\">");
	    resp.getWriter().println("<img  src='laptop.jpg' alt scr='Mountain View' width='240 height='140'/>");
	    resp.getWriter().println(" </a>");
	    resp.getWriter().println(" </div>");
	    resp.getWriter().println("</br> <div align='center'>");
	    resp.getWriter().println("<form type =\"submit\" method=\"post\" action='servlet3'>");
 		//list of available CPUs to select
	    resp.getWriter().println(" CPU:");
	    resp.getWriter().println("&emsp;");
	    resp.getWriter().println("<select name=\"CPU\">");
	    for (int i=0;i<4;i++){
	    	resp.getWriter().println("<option value=\""+CPU[i]+"\"><b>"+CPU[i]+"- Price:"+CostCPU[i]+"</b></option>");
	 
	    }
	    resp.getWriter().println("</select>");
	   
	   
	    //list of available RAMs to select
	    resp.getWriter().println("</br>");
	    resp.getWriter().println(" </br>");
	    resp.getWriter().println(" RAM:");
	    resp.getWriter().println("&emsp;&emsp;&emsp;");
	    resp.getWriter().println("<select  name=\"RAM\">");
	    for (int j=0;j<4;j++){
	    	resp.getWriter().println("<option value=\""+RAM[j]+"\"><b>"+RAM[j]+"- Price:"+CostRAM[j]+"</b></option>");
	    }
	    resp.getWriter().println("</select>");
	 	//list of available Hard Drives
	    resp.getWriter().println("</br>");
	    resp.getWriter().println(" </br>");
	    resp.getWriter().println(" Hard Drives:");
	    resp.getWriter().println("<select name=\"HardDrives\">");
	    for (int k=0;k<4;k++){
	    	resp.getWriter().println("<option value=\""+HardDrives[k]+"\"><b>"+HardDrives[k]+"- Price:"+CostHardDrives[k]+"</b></option>");
	    }resp.getWriter().println("</select></br>");
	    resp.getWriter().println("</br>");
	    //Specific Motherboard for type "Desktop"
	    resp.getWriter().println("Motherboard and Peripherals:        300 &euro; &emsp;&emsp;&emsp;&emsp;&emsp; ");

		 } 
	  else if ( Desktop.equals(Buy)){
		  Cookie TotalCostcookie = new Cookie ("TotalCost","200");
			TotalCostcookie.setMaxAge( 1200 );  
		  	resp.addCookie( TotalCostcookie );  
		  	//name and icon of chosen product 
		  	resp.getWriter().println(" <div align='center' style=\" overflow:auto; align:center\">");
			resp.getWriter().println("<b><font size=\"6\"> Desktop </font></b>");
			resp.getWriter().println("&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;");

		    resp.getWriter().println("</div>");
		    resp.getWriter().println("<div align=\"center\" style=\" background-color:white; height:250px;\">");
		    resp.getWriter().println("<img  src='desktop.png' alt scr='Mountain View' width='240 height='140'/>");
		    resp.getWriter().println(" </a>");
		    resp.getWriter().println(" </div>");
		    resp.getWriter().println("</br> <div align='center'>");
		    resp.getWriter().println("<form type =\"submit\" method=\"post\" action='servlet3'>");
		    //list of available CPUs to select
		    resp.getWriter().println(" CPU:");
		    resp.getWriter().println("&emsp;");
		    resp.getWriter().println("<select name=\"CPU\">");
		    for (int i=0;i<4;i++){
		    	resp.getWriter().println("<option value=\""+CPU[i]+"\"><b>"+CPU[i]+"- Price:"+CostCPU[i]+"</b></option>");
		    }
		    resp.getWriter().println("</select>");
		   
		    resp.getWriter().println("</br>"); 
		    resp.getWriter().println(" </br>");
		    //list of available RAMs to select
		    resp.getWriter().println(" RAM:");
		    resp.getWriter().println("&emsp;&emsp;&emsp;");
		    resp.getWriter().println("<select name=\"RAM\">");
		    for (int j=0;j<4;j++){
		    	resp.getWriter().println("<option value=\""+RAM[j]+"\"><b>"+RAM[j]+"- Price:"+CostRAM[j]+"</b></option>");
		    } 
		    resp.getWriter().println("</select>");
		    resp.getWriter().println("</br>");
		    resp.getWriter().println(" </br>");
		    //list of available Hard Drives to select
		    resp.getWriter().println(" Hard Drives:");
		    resp.getWriter().println("<select name=\"HardDrives\">");
		    for (int k=0;k<4;k++){
		    	resp.getWriter().println("<option value=\""+HardDrives[k]+"\"><b>"+HardDrives[k]+"- Price:"+CostHardDrives[k]+"</b></option>");
		    }resp.getWriter().println("</select></br>");
		    resp.getWriter().println("</br>");
		    //Specific Motherboard for type "Desktop"
		    resp.getWriter().println("Motherboard and Peripherals:        200 &euro; &emsp;&emsp;&emsp;&emsp;&emsp; ");



	 }else{
		 Cookie TotalCostcookie = new Cookie ("TotalCost","400");
			TotalCostcookie.setMaxAge( 1200 );  
		  	resp.addCookie( TotalCostcookie ); 
		  	//name and icon of chosen type of product 
		 	resp.getWriter().println(" <div align='center' style=\" overflow:auto; align:center\">");
			resp.getWriter().println("<b><font size=\"6\"> Gaming PC </font></b>");
			resp.getWriter().println("&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;");

		    resp.getWriter().println("</div>");
		    resp.getWriter().println("<div align=\"center\" style=\" background-color:white; height:250px;\">");
		    resp.getWriter().println("<img  src='gamingpc.png' alt scr='Mountain View' width='240 height='140'/>");
		    resp.getWriter().println(" </a>");
		    resp.getWriter().println(" </div>");
		    resp.getWriter().println("</br> <div align='center'>");
		   //list of available CPUs to select
		    resp.getWriter().println("<form type =\"submit\" method=\"post\" action='servlet3'>");
		    resp.getWriter().println(" CPU:");
		    resp.getWriter().println("&emsp;");
		    resp.getWriter().println("<select name=\"CPU\">");
		    for (int i=0;i<4;i++){
		    	resp.getWriter().println("<option value=\""+CPU[i]+"\"><b>"+CPU[i]+"- Price:"+CostCPU[i]+"</b></option>");
		    }
		    resp.getWriter().println("</select>");
		    resp.getWriter().println("</br>");
		    //list of available RAMs to select
		    resp.getWriter().println(" </br>");
		    resp.getWriter().println(" RAM:");
		    resp.getWriter().println("&emsp;&emsp;&emsp;");
		    resp.getWriter().println("<select name=\"RAM\">");
		    for (int j=0;j<4;j++){
		    	resp.getWriter().println("<option value=\""+RAM[j]+"\"><b>"+RAM[j]+"- Price:"+CostRAM[j]+"</b></option>");
		    }
		    resp.getWriter().println("</select>");
		    resp.getWriter().println("</br>");
		    resp.getWriter().println(" </br>");
		    //list of available Hard Drives to select
		    resp.getWriter().println(" Hard Drives:");
		    resp.getWriter().println("<select name=\"HardDrives\">");
		    for (int k=0;k<4;k++){
		    	resp.getWriter().println("<option value=\""+HardDrives[k]+"\"><b>"+HardDrives[k]+"- Price:"+CostHardDrives[k]+"</b></option>");
		    }resp.getWriter().println("</select></br>");		    resp.getWriter().println("</br>");
		    //Specific Motherboard for type "Gaming PC"
		    resp.getWriter().println("Motherboard and Peripherals:        400 &euro; &emsp;&emsp;&emsp;&emsp;&emsp; ");


		
	 }

	 		//Accept and Decline Button
		    resp.getWriter().println("</br>");
		    resp.getWriter().println("</br>");
		    resp.getWriter().println("</br>");
		    resp.getWriter().println("<input type=\"submit\" value=\"Accept\">");
		    resp.getWriter().println("</form>");
		    resp.getWriter().println("<form method=\"post\" action='servlet1'>");
		    resp.getWriter().println("<button id='b2' onclick='goBack()' type=\"submit\">Decline</button>");
		    resp.getWriter().println("</form>");
		    resp.getWriter().println("</div>");
	   
	    resp.getWriter().println(" </br>");
	   
	 resp.getWriter().println("</article>");
	//Footer	
	resp.getWriter().println("<div>");
	resp.getWriter().println("<footer>Copyright &copy; X-Port</footer>");	
	resp.getWriter().println("</div>");
	resp.getWriter().println("</body>");
	resp.getWriter().println("</html>");

}
}