package MyExceptions;

import Company.Company;

public class RemoveCompanyException extends Exception {

	private Company company;

	public RemoveCompanyException(Company company) {
		this.company = company;
	}

	public String getMessage() {
		return "Faild to remove " + this.company.getCompanyName() + "company";
	}

}