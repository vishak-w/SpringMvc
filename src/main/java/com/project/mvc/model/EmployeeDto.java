package com.project.mvc.model;


public class EmployeeDto {
	    private Integer id;
	    
	    private String firstName;
	    
	    private String lastName;
	    
	    private String email;
	    
	   

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	    @Override
	    public String toString() {
	        return "EmployeeEntity [id=" + id + ", firstName=" + firstName + 
	                ", lastName=" + lastName + ", email=" + email   + "]";
	    }
}
