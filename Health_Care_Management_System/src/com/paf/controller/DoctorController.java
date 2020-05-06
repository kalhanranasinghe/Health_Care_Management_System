package com.paf.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;  			
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.paf.model.Doctor;
import com.paf.util.DBConnection;

public class DoctorController {

	private static Connection connection;
	private static PreparedStatement ps;
	private static ResultSet rs;

	//add doctor
	public String AddDoctor(Doctor doctor) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			 if (connection == null)
			 {return "Error while connecting to the database for inserting."; } 
			
			ps = connection.prepareStatement(
					"INSERT INTO  doctor(Did,Dname,Dmail,Specialization,Dcontact) "
							+ "	VALUES (?,?,?,?,?)");

			ps.setInt(1, 0);
			ps.setString(2, doctor.getDname());
			ps.setString(3, doctor.getDmail());
			ps.setString(4, doctor.getSpecialization());
			ps.setString(5, doctor.getDcontact());
			

			ps.execute();
			String newdoctors = readDoctors();
			 //connection.close();
			 //output = "Inserted successfully"; 
			output = "{\"status\":\"success\", \"data\": \"" + newdoctors + "\"}";

		}
		 catch (Exception e)
		 {
		 output = "{\"status\":\"error\", \"data\":\"Error while doctor the item.\"}"; 
		 System.err.println(e.getMessage());
		 }
		 return output; 

		
	}

	//read details
	public String readDoctors() {
		String output="";
		
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				System.err.println("connecting failed.");
			}
			// Prepare the html table to be displayed
			

			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from doctor");
			

			// iterate through the rows in the result set
			while (rs.next()) {
				
				output+="<tr>" +
						"<td id=\'UpdateDid\' name=\'UpdateDid\'>" + 
						"<input  value=\'"+rs.getInt("Did")+"\' type=\'hidden\'>" + 
						 rs.getInt("Did") +
						"</td> "
						+"<td>"+rs.getString("Dname")+"</td>"
						+"<td>"+rs.getString("Dmail")+"</td>"
						+"<td>"+rs.getString("Specialization")+"</td>"
						+"<td>"+rs.getString("Dcontact")+"</td>"
						+"<td>" + 
						"<input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'>" + 
						"</td>" +
						"<td>" + 
						"<input name='btnRemove' type='button'" + 
						"value='Remove' class='btnRemove btn btn-danger' data-doctorid='"+rs.getInt("Did")+"'></td>" + 
						"</tr>";

				
			}
			
//			connection.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return output;
	}

	//update details
	public String updatedoctor(Doctor doctor) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			ps = connection.prepareStatement(
					"UPDATE doctor SET Dname=?,Dmail=?,Specialization=?,Dcontact=? WHERE Did=?");

			// binding values
			ps.setString(1, doctor.getDname());
			ps.setString(2, doctor.getDmail());
			ps.setString(3,doctor.getSpecialization());
			ps.setString(4, doctor.getDcontact());
			ps.setInt(5, doctor.getDid());
			// execute the statement
			ps.execute();
			//connection.close();
			String newdoctors =readDoctors();
			output = "{\"status\":\"success\", \"data\": \"" + newdoctors + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while updating the item.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	//delete details
	public String deleteDoctor(String Did) {
		String output = "";
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			connection = DBConnection.getConnection();
			ps = connection.prepareStatement("delete from doctor where Did=?");
			// binding values
			ps.setInt(1, Integer.parseInt(Did));
			// execute the statement
			ps.execute();
			//connection.close();
			String newdoctors = readDoctors();
			output = "{\"status\":\"success\", \"data\": \"" + newdoctors + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the item.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
	

	//search details
	public Doctor searchDoctors(String id) {
		Doctor doc = new Doctor();
		try {
			connection = DBConnection.getConnection();
			if (connection == null) {
				System.err.println("connecting failed.");
			}
			// Prepare the html table to be displayed
			

			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from doctor where Did="+id+"");
			

			// iterate through the rows in the result set
			
			while (rs.next()) {
				
				doc.setDid(rs.getInt("Did"));
				doc.setDname(rs.getString("Dname"));
				doc.setDmail(rs.getString("Dmail"));
				doc.setSpecialization(rs.getString("Specialization"));
				doc.setDcontact(rs.getString("Dcontact"));
			}
			//connection.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return doc;
	}

}
