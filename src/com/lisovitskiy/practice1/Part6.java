package com.lisovitskiy.practice1;

public class Part6 {
	public enum UsersStatus {

		PENDING("Medium"), ACTIVE("High"), INACTIVE("Low"), DELETED("Trivial");
		private final String priority;

		UsersStatus(final String priority) {
			this.priority = priority;
		}

		public String getPriority() {
			System.out.println(priority);
			return priority;
		}
	}
	public static void main(String[] args) {
		for(UsersStatus ustatus: UsersStatus.values()){
			ustatus.getPriority();
		}
	}

}
