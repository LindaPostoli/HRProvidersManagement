package it.synclab.hrpm.model;

public class Rating implements Entity {

	private int id;
	private int professional;
	private int personality;
	private int mark;

	public static final String HEADER = "ID;PROFESSIONAL_IMPRESSIONS;PERSONALITY_IMPRESSIONS;MARK";
	// TODO: insert attributo per il numero di colloqui (se più di uno)

	public Rating(int id, int professional, int personality, int mark) {
		this.id = id;
		this.professional = professional;
		this.personality = personality;
		this.mark = mark;
	}
	
	public Rating(String id) {
		this.id = Integer.parseInt(id);
	}

	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id
	 *            as Integer format
	 *            
	 */
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProfessional() {
		return professional;
	}
	
	/**
	 * 
	 * @param id
	 *            as Integer format
	 *            
	 */
	public void setProfessional(String professional) {
		this.id = Integer.parseInt(professional);
	}

	public void setProfessional(int professional) {
		this.professional = professional;
	}

	public int getPersonality() {
		return personality;
	}
	
	/**
	 * 
	 * @param id
	 *            as Integer format
	 *            
	 */
	public void setPersonality(String personality) {
		this.personality = Integer.parseInt(personality);
	}

	public void setPersonality(int personality) {
		this.personality = personality;
	}

	public int getMark() {
		return mark;
	}
	
	/**
	 * 
	 * @param id
	 *            as Integer format
	 *            
	 */
	public void setMark(String mark) {
		this.mark = Integer.parseInt(mark);
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public static String getHeader() {
		return HEADER;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", professional=" + professional + ", personality=" + personality + ", mark=" + mark
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + mark;
		result = prime * result + personality;
		result = prime * result + professional;
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
		if (id != other.id)
			return false;
		if (mark != other.mark)
			return false;
		if (personality != other.personality)
			return false;
		if (professional != other.professional)
			return false;
		return true;
	}

	public String toCSV() {
		return professional + ";" + personality + ";" + mark + ";";
	}

	public String getKey() {
		return String.valueOf(id);
	}
}