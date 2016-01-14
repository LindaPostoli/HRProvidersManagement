package it.synclab.hrpm.model;

public class JobWebsite implements Channel {

	private String url, name;
	private static final String HEADER = "URL;NAME";

	public JobWebsite(String url) {
		this.url = url;
	}
	
	public JobWebsite() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHeader() {
		return HEADER;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		JobWebsite other = (JobWebsite) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JobWebsite [name=" + name + ", url=" + url + "]";
	}

	public String toCSV() {
		return url + ";" + name;
	}

	public String getKey() {
		return url;
	}
}
