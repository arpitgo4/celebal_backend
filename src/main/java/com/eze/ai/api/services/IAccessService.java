package com.eze.ai.api.services;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.eze.ai.api.models.Access;

public interface IAccessService {
	void GoogleCalendarDetail(Access access) throws IOException;
	void OutlookCalendarDetail(Access access) throws ClientProtocolException, IOException;
	

}
