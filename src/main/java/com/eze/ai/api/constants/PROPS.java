
package com.eze.ai.api.constants;

public interface PROPS {
	public static interface SystemProps {
		String CONF_DIR = "confDir";
		String LOG_DIR = "logDir";
	}

	public static interface AerospikeConstants {
			String AERO_HOSTS = "aerospike.hosts";
			String AERO_PORT = "aerospike.port";
			String DATA_NAMESPACE = "data.namespace.name";
			String PROP_CACHE_SET = "ram.set.PROP_CACHE.name";
			String PRJ_CACHE_SET = "ram.set.PRJ_CACHE.name";
			String PSM_CACHE_SET = "ram.set.PSM_CACHE.name";
			String userIdSet = "ram.set.USERID.name";
			String userIdToRamUserIdMappingSet= "";
	}
	
	public static interface SolrProps {
		String SOLR_HOSTS = "solr.hosts";
		String PRJ_SOLR_HOSTS = "prj.solr.hosts";
		String PSM_SOLR_HOSTS = "psm.solr.hosts";
		String SOLR_PORT = "solr.port";
	}

	public static interface CassandraProps{
		String  RAM_CASSANDRA_HOSTS = "cassandra.hosts";
		String  RAM_CASSANDRA_PORT = "cassandra.port";
		
	}
}
