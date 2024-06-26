package com.example.demospring.departement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.example.demospring.exepctions.DepartmentExistException;

@RestController
@RequestMapping("/departement")
public class DepartementController {
	
		private final DepartementService ser;
		
		@Autowired
		public DepartementController(DepartementService ser) {
			this.ser = ser;
		}
		
		
		// manager end point
		@PostMapping("/add")
		public void addept(@RequestBody Departement dept) {
			try {
				ser.adddepartement(dept.getNom_dept());
			} catch (DepartmentExistException e) {
				e.printStackTrace();
			}
		}
		
		@DeleteMapping("/delete") // to insert not name -> nom_dept
		public void deldept(@RequestBody Long id) {
			ser.deletedept(id);
		}
		
		@PutMapping("/modify")
		public void updatedept(@RequestBody Departement name) {
			ser.modifydept(name);
		}
		
		
		
		//manager end point
		@GetMapping("/all")
		public List<Departement> getdept(){
			return ser.showdepartement();
		}
		
}
