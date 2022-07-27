package com.Milestone1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;


public class Milestone_1 {
	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader("C:\\Users\\apatr\\Desktop\\Workspace\\1805164.csv");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection sqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/h2h_internship",
					"root","Shivjeet1");  
			
			sqlConnection.setAutoCommit(false);
			String sql = "INSERT INTO invoice_details VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement  statement = sqlConnection.prepareStatement(sql);
			
			
			String line = "";
			bufferedReader.readLine();
			int batchSize = 100;
			int count =0;

			while( (line = bufferedReader.readLine()) != null) {
				String data[] = line.split(",");
				statement.setString(1,data[0]);//business_code
				statement.setString(2,data[1]);//cust_number` varchar(255)
				statement.setString(3,data[2]);//name_customer` varchar(255
				statement.setString(4,handleNull(data[3]) );//clear_date` datetime
				statement.setString(5,data[4]);//business_year` year(4)
				statement.setString(6, data[5]);//doc_id` int(11)
				statement.setString(7,data[6]);//posting_date` date
				statement.setString(8,data[7]);//document_create_date
				statement.setString(9,data[9]);//due_in_date` date
				statement.setString(10,data[10]); //invoice_currency` char(3)
				statement.setString(11,data[11]);  //document_type` char(2
				statement.setFloat(12,castStringToFloat(data[12]));  //posting_id` tinyint(4)
				statement.setString(13,data[13]);   //area_business` varchar(255)
				statement.setDouble(14,Double.parseDouble(data[14]));   //total_open_amount` double
				statement.setString(15,data[15]);	//baseline_create_date` date
				statement.setString(16,data[16]);	//cust_payment_terms` char(4) 
				//System.out.println(data[17]+" "+castDoubleToInt(data[17]));
				statement.setDouble(17,castStringToDouble(data[17]));	//invoice_id` int(11)
				statement.setFloat(18,castStringToFloat(data[18]));	//isOpen` tinyint(4)
				statement.addBatch();
				count++;
				if(count %batchSize ==0)
					statement.executeBatch();
				System.out.println(count);
				
				
			}
			statement.executeBatch();
			sqlConnection.commit();
			
			fileReader.close();
			bufferedReader.close();
			statement.close();
			sqlConnection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static float castStringToFloat(String s) {
		if(s==null) return Types.NULL;
		if(s.isEmpty()) return Types.NULL;
		
		float temp = Float.parseFloat(s);
		return temp;
		
	}
	
	public static double castStringToDouble(String s) {
		if(s==null) return Types.NULL;
		if(s.isEmpty()) return Types.NULL;
		
		double temp = Double.parseDouble(s);
		return temp;
		
	}
	
	public static int castDoubleToLong(String s) {
		if(s==null) return (int) Types.NULL;
		if(s.isEmpty()) return (int) Types.NULL;
		
		double temp = Double.parseDouble(s);		
		long tempInt = (long) temp;		
		return (int)(tempInt);
		
	}
	public static String handleNull(String s) {
		if(s.isEmpty()) return null;
		if(s=="") return null;
		if(s.length()==0) return null;
		return s;
		
	}

}
