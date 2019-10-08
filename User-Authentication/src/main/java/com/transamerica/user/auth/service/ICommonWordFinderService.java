package com.transamerica.user.auth.service;

import java.util.Set;

public interface ICommonWordFinderService {
	Set<String> findCommandWord(String filesPath);
}
