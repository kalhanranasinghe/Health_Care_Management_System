package com.paf.service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
import com.paf.controller.DoctorController;
import com.paf.model.Doctor;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Doctor")
public class DoctorService {
	
	DoctorController doctorController = new DoctorController();

	@GET
	@Path("/read")
	@Produces({ MediaType.TEXT_PLAIN })
	public String readItems() {
		return new Gson().toJson(doctorController.readDoctors());
	}

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDoctor(@FormParam("Dname") String Dname, @FormParam("Dmail") String Dmail,
			@FormParam("Specialization") String Specialization, @FormParam("Dcontact") String Dcontact
			) throws ParseException {

		Doctor doctor = new Doctor();
		doctor.setDname(Dname);
		doctor.setDmail(Dmail);
		doctor.setSpecialization(Specialization);
		doctor.setDcontact(Dcontact);

		return doctorController.AddDoctor(doctor);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoctor(@PathParam("id")String Did) {

		return doctorController.deleteDoctor(Did);
	}
	
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctor(@FormParam("Dname") String Dname, @FormParam("Dmail") String Dmail,
			@FormParam("Specialization") String Specialization, @FormParam("Dcontact") String Dcontact
			) throws ParseException {

		Doctor doctor = new Doctor();
		doctor.setDname(Dname);
		doctor.setDmail(Dmail);
		doctor.setSpecialization(Specialization);
		doctor.setDcontact(Dcontact);

		return doctorController.updatedoctor(doctor);
	}
	
	@GET
	@Path("/search/{id}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String searchDoctor(@PathParam("id")String Did) {
		return new Gson().toJson(doctorController.searchDoctors(Did));
	}
	

}
