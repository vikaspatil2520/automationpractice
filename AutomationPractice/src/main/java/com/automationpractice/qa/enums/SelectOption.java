package com.automationpractice.qa.enums;

public enum SelectOption {
	INDEX {
		@Override
		public String toString() {
			return "index";		}
	},
	VALUE {
		@Override
		public String toString() {
			return "value";		}
	},
	VISIBLETEXT {
		@Override
		public String toString() {
			return "visibleText";
		}
	}
}
