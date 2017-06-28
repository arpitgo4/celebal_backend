package com.eze.ai.api.constants;


public final class BDSAPIConstants {

	/**
	 * no instantiation needed
	 * 
	 * @constructor RAMViewerConstants
	 */
	private BDSAPIConstants() {

	}

	public static interface AnnotationValues {
		String JSON = "application/json";
		String PROFILE_URL = "/ramViewer/profile";
		String DUMMY_URL = "/dummy";
		String USER_URL = "/user/{userId:.+}";
		String USER_URL_RID="/rid/{rid:.+}";
		String USER_STATIC_URL = "/static" + USER_URL;
		String USER_ALL_REQMT_URL = USER_URL + "/requirements";
		String REQMT_SEARCH_CRITERIA = USER_URL + "/reqmtSearch";
		String REQMT_SERACH_CRITERIA_SORTED_PARAMS = REQMT_SEARCH_CRITERIA
				+ "/sortedParamAll/{trackedParam}";
		String REQMT_SEARCH_CRITERIA_BEST_PARAM = REQMT_SEARCH_CRITERIA
				+ "/bestParam/{trackedParam}";
		String USER_REQMT_URL = USER_ALL_REQMT_URL + "/{reqmtKey}";
		String USER_STATIC_REQMT_URL = "/static" + USER_REQMT_URL;
		String STATIC_REQMT_SEARCH_CRITERIA = USER_STATIC_URL + "/reqmtSearch";
		/**
		 * 
		 * Solr Constant for Viewer
		 */
		
		String SOLR_PROFILE_URL = "/ramViewer/solrProfile";
		String SOLR_USER_URL = "/user/{userId}";
		String SOLR_CITY_USER_URL = "/city/{cityId}";
		String SOLR_PARAM_URL = "/{cityId}/{param}/{paramId}";
		
		String STATS_URL = "/ramViewer/stats/";
		String STATS_HOULRLY_EVENT = "/event/hourly/{eventType}";
		String STATS_DETAILED_DAY_ENDPOINT = "/day/detailed/{service}/{dd_mm_yyyy}";
		String STATS_AGGREGATED_DAY_ENDPOINT = "/day/aggregated/{service}/{dd_mm_yyyy}";
		String STATS_DETAILED_MONTH_ENDPOINT = "/month/detailed/{service}/{mm_yyyy}";
		String STATS_AGGREGATED_MONTH_ENDPOINT = "/month/aggregated/{service}/{mm_yyyy}";
		String USER_STATS_DETAILED_DAY_ENDPOINT = "/user/day/detailed/{dd_mm_yyyy}";
		String USER_STATS_AGGREGATED_DAY_ENDPOINT = "/user/day/aggregated/{dd_mm_yyyy}";
		String USER_STATS_DETAILED_MONTH_ENDPOINT = "/user/month/detailed/{mm_yyyy}";
		String USER_STATS_AGGREGATED_MONTH_ENDPOINT = "/user/month/aggregated/{mm_yyyy}";

	}

}
