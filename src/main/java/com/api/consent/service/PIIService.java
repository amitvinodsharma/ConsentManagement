package com.api.consent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.consent.dao.PIIDAO;
import com.api.consent.model.PII;

@Service("piiService")
public class PIIService {

	@Autowired
	PIIDAO piiDao;
	
	@Transactional
	public List<PII> getAllPIIs() {
		return piiDao.getAllPIIs();
	}

	@Transactional
	public PII getPII(int id) {
		return piiDao.getPII(id);
	}

	@Transactional
	public PII addPII(PII pII) {
		Integer id = piiDao.addPII(pII);
		pII.setId(id);
		return pII;
	}

	@Transactional
	public PII updatePII(PII pII) {
		return piiDao.updatePII(pII);

	}

	@Transactional
	public void deletePII(int id) {
		piiDao.deletePII(id);
	}
}
