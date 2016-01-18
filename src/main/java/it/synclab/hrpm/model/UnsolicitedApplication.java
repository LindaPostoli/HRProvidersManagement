package it.synclab.hrpm.model;

public class UnsolicitedApplication implements Channel {

	private int id;
				
	public UnsolicitedApplication() {
		super();
	}
	
	public UnsolicitedApplication(String id){
		this.id = Integer.parseInt(id);
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeader() {
		return null;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnsolicitedApplication other = (UnsolicitedApplication) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UnsolicitedApplication [id=" + id + "]";
	}

	public String toCSV() {
		return id + "Unsolicited Application";
	}
	
	public String getKey() {
		return String.valueOf(id);
	}
	
	
}
