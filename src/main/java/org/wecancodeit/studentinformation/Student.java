package org.wecancodeit.studentinformation;

public class Student {

	private long id;
	private String name;
	private String gitHubUrl;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGitHubUrl() {
		return gitHubUrl;
	}

	public Student(long id, String name, String gitHubUrl) {
		this.id = id;
		this.name = name;
		this.gitHubUrl = gitHubUrl;
	}

}
