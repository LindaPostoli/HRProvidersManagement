package it.synclab.hrpm.model;

public class Rating implements Entity {

	private String id;
	private String professionalImpressions;
	private String personalityImpressions;
	private int mark;

	public static final String HEADER = "ID; PROFESSIONAL_IMPRESSIONS; PERSONALITY_IMPRESSIONS; MARK;";
	// TODO: insert attributo per il numero di colloqui (se più di uno)

	public String getProfessionalImpressions() {
		return professionalImpressions;
	}

	public void setProfessionalImpressions(String professionalImpressions) {
		this.professionalImpressions = professionalImpressions;
	}

	public String getPersonalityImpressions() {
		return personalityImpressions;
	}

	public void setPersonalityImpressions(String personalityImpressions) {
		this.personalityImpressions = personalityImpressions;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public static String getHeader() {
		return HEADER;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", professionalImpressions=" + professionalImpressions + ", personalityImpressions="
				+ personalityImpressions + ", mark=" + mark + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + mark;
		result = prime * result + ((personalityImpressions == null) ? 0 : personalityImpressions.hashCode());
		result = prime * result + ((professionalImpressions == null) ? 0 : professionalImpressions.hashCode());
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
		Rating other = (Rating) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mark != other.mark)
			return false;
		if (personalityImpressions == null) {
			if (other.personalityImpressions != null)
				return false;
		} else if (!personalityImpressions.equals(other.personalityImpressions))
			return false;
		if (professionalImpressions == null) {
			if (other.professionalImpressions != null)
				return false;
		} else if (!professionalImpressions.equals(other.professionalImpressions))
			return false;
		return true;
	}

	public String toCSV() {
		return professionalImpressions + ";" + personalityImpressions + ";" + mark + ";";
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id;
	}

}
