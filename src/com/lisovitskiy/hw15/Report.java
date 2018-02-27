package com.lisovitskiy.hw15;

import java.util.List;

public class Report {
	private ScheduleDAO sd = ScheduleDAO.INSTANCE;

	private final static String SELECT_PROFESSORS_WORKING_ON_DAY_IN_AUDIENCE = "SELECT p.id_professors, full_name, audience_id_audience AS auidience, name "
			+ "FROM professors p " + "INNER JOIN professors_have_subjects ps "
			+ "ON p.id_professors = ps.id_professors " + "INNER JOIN subjects subj "
			+ "ON ps.id_subjects = subj.id_subjects " + "INNER JOIN audience_has_subjects a_subj "
			+ "ON ps.id_subjects = a_subj.subjects_id_subjects " + "WHERE audience_id_audience = ? AND day = ?";

	private final static String SELECT_PROFESSORS_NOT_WORKING_ON_DAY = "SELECT * FROM professors_have_subjects "
			+ "LEFT JOIN audience_has_subjects ON professors_have_subjects.id_subjects = audience_has_subjects.subjects_id_subjects "
			+ "WHERE NOT day = ?";

	private final static String SELECT__DAYS_BY_NUMBER_OF_LESSONS = "SELECT day, COUNT(subjects_id_subjects) AS 'number of lessons' "
			+ "FROM audience_has_subjects GROUP BY day HAVING COUNT(subjects_id_subjects) = ?";

	private final static String SELECT_DAYS_BY_OCCUPIED_AUDIENCES = "SELECT day, COUNT(audience_id_audience) AS 'number of audiences' "
			+ "FROM audience_has_subjects GROUP BY day HAVING COUNT(audience_id_audience) = ?";

	public List<String> professorsWorkingOnDayAndAudience(String audience, String day) {
		return sd.performQuery(SELECT_PROFESSORS_WORKING_ON_DAY_IN_AUDIENCE, audience, day);
	}

	public List<String> professorsNotWorkingOnDay(String day) {
		return sd.performQuery(SELECT_PROFESSORS_NOT_WORKING_ON_DAY, day);
	}

	public List<String> daysByNumberOfLessons(String numberOfLessons) {
		return sd.performQuery(SELECT__DAYS_BY_NUMBER_OF_LESSONS, numberOfLessons);
	}

	public List<String> daysByOccupiedAudiences(String numberOfAudiences) {
		return sd.performQuery(SELECT_DAYS_BY_OCCUPIED_AUDIENCES, numberOfAudiences);
	}

	public static void main(String[] args) {
		Report r = new Report();
		r.daysByNumberOfLessons("15");
	}

}
