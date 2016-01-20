package it.synclab.hrpm.model;

public class Rating implements Entity {

	private int id;
	private int professionality;
	private int personality;
	private int general;
	private String note;

	public static final String HEADER = "ID;PROFESSIONAL_IMPRESSIONS;PERSONALITY_IMPRESSIONS;GENERAL;NOTE";
	// TODO: insert attributo per il numero di colloqui (se più di uno)

	public Rating(int id, int professionality, int personality, int mark) {
		this.id = id;
		this.professionality = professionality;
		this.personality = personality;
		this.general = mark;
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

	public int getProfessionality() {
		return professionality;
	}

	/**
	 * 
	 * @param Professional
	 *            as Integer format
	 * 
	 */
	public void setProfessionality(String professionality) {
		this.professionality = Integer.parseInt(professionality);
	}

	public void setProfessionality(int professionality) {
		this.professionality = professionality;
	}

	public int getPersonality() {
		return personality;
	}

	/**
	 * 
	 * @param personality
	 *            as Integer format
	 * 
	 */
	public void setPersonality(String personality) {
		this.personality = Integer.parseInt(personality);
	}

	public void setPersonality(int personality) {
		this.personality = personality;
	}

	public int getGeneral() {
		return general;
	}

	/**
	 * 
	 * @param mark
	 *            as Integer format
	 * 
	 */
	public void setGeneral(String general) {
		this.general = Integer.parseInt(general);
	}

	public void setGeneral(int general) {
		this.general = general;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public static String getHeader() {
		return HEADER;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", professionality=" + professionality + ", personality=" + personality
				+ ", general=" + general + ", note=" + note + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + general;
		result = prime * result + id;
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + personality;
		result = prime * result + professionality;
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
		if (general != other.general)
			return false;
		if (id != other.id)
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (personality != other.personality)
			return false;
		if (professionality != other.professionality)
			return false;
		return true;
	}

	public String toCSV() {
		return id + ";" + professionality + ";" + personality + ";" + general + ";" + note;
	}

	public String getKey() {
		return String.valueOf(id);
	}
}