package com.eze.ai.api.constants;


public abstract class BDSConstants {

	// Instantiion or Extension not Allowed
	private BDSConstants() {

	}

	/**
	 * Event Names Constants
	 * 
	 * @author Ketan.Dikshit
	 *         ramIngestorService/com.magicbricks.bds.ingestorService. consts/
	 *         EVENTS
	 */
	public static enum EVENTS {
		CONTACT_EVENT("CONTACT_API"), DETAILVIEW_EVENT("DETAILVIEW_API"),
		REQMT_EVENT("REQMT_API"), SEARCH_EVENT("SEARCH_API"),
		APP_STATUS("APP_STATUS_API"), MAILSENT_EVENT("MAILSENT_API"),
		MAILOPEN_EVENT("MAILOPEN_API"),
		NOTIFICATION_SENT_EVENT("NOTIFICATION_SENT_API"),
		NOTIFICATION_OPEN_EVENT("NOTIFICATION_OPEN_API"),
		SHORTLIST_EVENT("SHORTLIST_EVENT_API"),
		COMPARE_EVENT("COMPARE_EVENT_API"), ASandBD_EVENT("ASandBD_EVENT_API"),
		BRO_NOTI_EVENT("BRO_NOTI_EVENT_API");

		String eventAPI;
		private EVENTS(String eventAPI) {
			this.eventAPI = eventAPI;
		}

		/**
		 * Get the corresponding api-name for this event
		 * 
		 * @return the assaited api-name
		 */
		public String API_NAME() {
			return eventAPI;
		}
	}

	/**
	 * Tracked Profile Parameters Constant Values
	 * 
	 * @Important: Never Change the mapping of the enum parameters to their
	 *             unique integer values
	 * 
	 * @author Ketan.Dikshit <br>
	 *         Feb 4, 2016 11:37:21 AM <br>
	 *         ramProfileManager/com.magicbricks.bds.ramProfileManager.constants
	 *         /TrackedProfileParams
	 */
	public static enum TrackedProfileParams {
		locality(1), budget(2), bedroom(3), propType(4), postedBy(5),
		alertType(6), constructionStatus(7), transType(8), possessionIn(9),
		bathrooms(10), furnishStatus(11), area(12), device(13), SL(14), VM(15),
		mailOpenTiming(16);

		private int value;
		private TrackedProfileParams(int val) {
			this.value = val;
		}

		/**
		 * Gives the value for this enum to be used for DB and other important
		 * purposes
		 * 
		 * @return the value for this enum
		 */
		public String getVal() {
			return String.valueOf(this.value);
		}

		/**
		 * Return the corresponding tracked profile for the associate value
		 * 
		 * @param val
		 *            the associated value with an instance of
		 *            {@link TrackedProfileParams}
		 * @return the corresponding associated instance of
		 *         {@link TrackedProfileParams} , 'null' otherwise
		 */
		public static TrackedProfileParams getEnumFromVal(String val) {
			int value = Integer.parseInt(val);
			switch (value) {
				case 1 :
					return locality;
				case 2 :
					return budget;
				case 3 :
					return bedroom;
				case 4 :
					return propType;
				case 5 :
					return postedBy;
				case 6 :
					return alertType;
				case 7 :
					return constructionStatus;
				case 8 :
					return transType;
				case 9 :
					return possessionIn;
				case 10 :
					return bathrooms;
				case 11 :
					return furnishStatus;
				case 12 :
					return area;
				case 13 :
					return device;
				case 14 :
					return SL;
				case 15 :
					return VM;
				case 16 :
					return mailOpenTiming;
				default :
					return null;
			}
		}

	}

	/**
	 * Counters Representaion for all the Events supported by Ingestor API
	 * 
	 * @author Ketan.Dikshit
	 *         ramIngestorService/com.magicbricks.bds.ingestorService.config/
	 *         CounterNames
	 */
	public static enum CounterNames {
		// Contact Events Counters
		CON_REC, CON_V_ERR,
		CON_J_ERR, CON_SUC,
		// Detail View Events Counters
		DV_REC, DV_V_ERR,
		DV_J_ERR, DV_SUC,
		// Requirement Events Counters
		REQ_REC, REQ_V_ERR,
		REQ_J_ERR, REQ_SUC,
		// Search Events Counters
		SRH_REC, SRH_V_ERR,
		SRH_J_ERR, SRH_SUC,
		// Mail Sent Events Counters
		MS_REC, MS_V_ERR,
		MS_J_ERR, MS_SUC,
		// Mail Open Events Counters
		MO_REC, MO_V_ERR,
		MO_J_ERR, MO_SUC,
		// NotificationSentBean Events Counters
		NOS_REC,
		NOS_V_ERR,
		NOS_J_ERR, NOS_SUC,
		// Notification Open Event Counters
		NOO_REC,
		NOO_V_ERR,
		NOO_J_ERR, NOO_SUC,
		// Shortlist Events Counters
		SL_REC, SL_V_ERR,
		SL_J_ERR, SL_SUC,
		// Shortlist Events Counters
		COM_REC, COM_V_ERR,
		COM_J_ERR, COM_SUC,
		// AS and BD Counters
		AB_REC, AB_V_ERR,
		AB_J_ERR, AB_SUC,
		GEN_UPD, STC_UPD, SCO_UPD,
		// Browser Notification Events Counters
		B_N_REC, B_N_V_ERR,
		B_N_J_ERR, B_N_SUC;
	}

	/**
	 * Static profile paraams where scoring is not done for these params
	 * 
	 * @author Ketan.Dikshit <br>
	 *         Feb 17, 2016 2:14:23 PM <br>
	 *         models/com.magicbricks.bds.constants/StaticProfileParams
	 */
	public static enum StaticProfileParams {
		pointOfInterest(1), budgetPerSqftMin(2), budgetPerSqftMax(3),
		minSqftArea(4), amenities(5), additionalRooms(6), preferredFloor(7),
		parkingType(8), numOfParking(9), facing(10), overlooking(11),
		preferredPSM(12), preferredBuilder(13), societyType(14),
		maxBrokerage(15), maxSecurity(16), dealsOffersInterests(17),
		dealingIn(18), featuredAgent(19), budget_min(20), budget_max(21), area_min(22), area_max(23);

		private int value;
		private StaticProfileParams(int value) {
			this.value = value;
		}

		/**
		 * Returns the corresponding Val that should be stored in DB for this
		 * {@link StaticProfileParams} type
		 * 
		 * @return the associated-value for storage in DB
		 */
		public String getVal() {
			return String.valueOf(value);
		}

		/**
		 * Get the StaticProfileParams enum for the value
		 * 
		 * @param val
		 *            value for which corresponding enum is needed
		 * @return the required enum({@link StaticProfileParams}) if valid, else
		 *         'null'
		 */
		public static StaticProfileParams getEnumFromVal(String val) {
			int mappedVal = Integer.parseInt(val);
			switch (mappedVal) {
				case 1 :
					return pointOfInterest;
				case 2 :
					return budgetPerSqftMin;
				case 3 :
					return budgetPerSqftMax;
				case 4 :
					return minSqftArea;
				case 5 :
					return amenities;
				case 6 :
					return additionalRooms;
				case 7 :
					return preferredFloor;
				case 8 :
					return parkingType;
				case 9 :
					return numOfParking;
				case 10 :
					return facing;
				case 11 :
					return overlooking;
				case 12 :
					return preferredPSM;
				case 13 :
					return preferredBuilder;
				case 14 :
					return societyType;
				case 15 :
					return maxBrokerage;
				case 16 :
					return maxSecurity;
				case 17 :
					return dealsOffersInterests;
				case 18 :
					return dealingIn;
				case 19 :
					return featuredAgent;
				case 20 :
					return budget_min;
				case 21 :
					return budget_max;
				case 22 :
					return area_min;
				case 23 :
					return area_max;	
				default :
					return null;
			}
		}
	}

	/**
	 * Represents the positions in the mail to the user
	 * 
	 * @author Ketan.Dikshit <br>
	 *         Feb 17, 2016 2:17:54 PM <br>
	 *         models/com.magicbricks.bds.constants/Position
	 */
	public static enum Position {
		mailSent_pos1(-1), mailOpen_pos1(1), mailOpen_pos2(2), mailOpen_pos3(3),
		mailOpen_pos4(4), mailOpen_pos5(5), mailOpen_pos6(6), mailOpen_pos7(7),
		mailOpen_pos8(8), mailOpen_pos9(9), mailOpen_pos10(10);

		private int posNumber;
		private Position(int posNumber) {
			this.posNumber = posNumber;
		}

		/**
		 * Get position enum from the index of the prop-position in the mail
		 * 
		 * @param posIndex
		 *            the position of the prop in mail
		 * @return the corresponding enum of type {@link Position}, else null
		 */
		public static Position getPositionFromIndex(int posIndex) {
			switch (posIndex) {
				case 1 :
					return mailOpen_pos1;
				case 2 :
					return mailOpen_pos2;
				case 3 :
					return mailOpen_pos3;
				case 4 :
					return mailOpen_pos4;
				case 5 :
					return mailOpen_pos5;
				case 6 :
					return mailOpen_pos6;
				case 7 :
					return mailOpen_pos7;
				case 8 :
					return mailOpen_pos8;
				case 9 :
					return mailOpen_pos9;
				case 10 :
					return mailOpen_pos10;
				default :
					return null;
			}
		}

		/**
		 * Get position-index for enum type: {@link Position}
		 * 
		 * @param pos
		 *            instance of {@link Position}
		 * @return the corresponding index for the position
		 */
		public static int getPositionIndex(Position pos) {
			return pos.posNumber;
		}

		/**
		 * Get position-index for 'this' enum type
		 * 
		 * @return the corresponding index for the position
		 */
		public int getPositionIndex() {
			return this.posNumber;
		}

	}

	/**
	 * Diffeerent Types of Scores that are maintained for
	 * {@link TrackedProfileParams}
	 * 
	 * @author Ketan.Dikshit <br>
	 *         Feb 17, 2016 2:21:31 PM <br>
	 *         models/com.magicbricks.bds.constants/Scores
	 */
	public static enum Scores {
		SITE_SCORE(1), ALERT_SENT_SCORE(2), ALERT_FEEDBACK_SCORE(3),
		COMPUTED_SCORE(4);

		private int value;
		private Scores(int value) {
			this.value = value;
		}

		/**
		 * Get the value for this enum, that would be stored in AERO
		 * 
		 * @return the value for this Enum of type {@link Scores}
		 */
		public String getVal() {
			return String.valueOf(value);
		}

		/**
		 * Get the enum of type {@link Scores} for the value associated
		 * 
		 * @param val
		 *            the val that was stored in AERO-DB
		 * @return the corresponding Score for the value stored in AERO
		 */
		public static Scores getScoreFromVal(String val) {
			int scoreVal = Integer.parseInt(val);

			switch (scoreVal) {
				case 1 :
					return SITE_SCORE;
				case 2 :
					return ALERT_SENT_SCORE;
				case 3 :
					return ALERT_FEEDBACK_SCORE;
				case 4 :
					return COMPUTED_SCORE;

				default :
					return null;
			}
		}
	}

	/**
	 * Generic Profile Params for UserReqmtToGenericProfileFieldsSET
	 * 
	 * @author Ketan.Dikshit <br>
	 *         Feb 18, 2016 10:16:13 PM <br>
	 *         models/com.magicbricks.bds.constants/GenericParamsForUserReqmt
	 */
	public static enum GenericParamsForUserReqmt {
		creationDate(1), lastUpdatedDate(2), userInfo(3), lastUpdateInfo(4);

		private int val;
		private GenericParamsForUserReqmt(int val) {
			this.val = val;
		}

		/**
		 * Get the corresponding code associated for Enum
		 * 
		 * @return the associated code for this enum
		 */
		public int getVal() {
			return this.val;
		}

		/**
		 * Get the Enum for the corresponding associated code
		 * 
		 * @param val
		 *            the assocaited code
		 * @return the corresponding Enum for the code, null otherwise
		 */
		public static GenericParamsForUserReqmt getParamFromVal(int val) {
			switch (val) {
				case 1 :
					return creationDate;
				case 2 :
					return lastUpdatedDate;
				case 3 :
					return userInfo;
				case 4 :
					return lastUpdateInfo;
				default :
					return null;
			}
		}

	}

	public static enum StaticDataType {
		shortlist, compared, rejected, preferred;
	}

	public static enum AnalyticUpdateEventType {
		generalInfoUpdate, staticInfoUpdate, scoringInfoUpdate;

		public static AnalyticUpdateEventType getEnumFromName(String name) {
			if (generalInfoUpdate.name().equalsIgnoreCase(name))
				return generalInfoUpdate;
			else if (staticInfoUpdate.name().equalsIgnoreCase(name))
				return staticInfoUpdate;
			else if (scoringInfoUpdate.name().equalsIgnoreCase(name))
				return scoringInfoUpdate;
			else
				return null;
		}
	}

}
