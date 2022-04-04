package com.diploma.admisssion.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;

import com.diploma.admisssion.exceptions.AdmittedAlreadyException;
import com.diploma.admisssion.model.Admissions;
import com.itextpdf.text.DocumentException;

public interface AdmissionService {
    
    public Admissions saveAdmission(Admissions adts) throws AdmittedAlreadyException;

    public void draftPDF(Admissions adresp) throws FileNotFoundException, DocumentException, IOException;

    public void sendEmailWithReport(Admissions adresp) throws MessagingException;

    public void sendEmail(Admissions adresp) throws MessagingException;
    
}
