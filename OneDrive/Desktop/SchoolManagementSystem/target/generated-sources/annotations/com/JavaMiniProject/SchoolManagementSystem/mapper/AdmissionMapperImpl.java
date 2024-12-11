package com.JavaMiniProject.SchoolManagementSystem.mapper;

import com.JavaMiniProject.SchoolManagementSystem.dto.AddressDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.AdmissionDetailDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.MedicalInformationDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.ParentGuardianDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.PreviousAcadamicDetailDTO;
import com.JavaMiniProject.SchoolManagementSystem.dto.StudentDTO;
import com.JavaMiniProject.SchoolManagementSystem.model.Address;
import com.JavaMiniProject.SchoolManagementSystem.model.AdmissionDetail;
import com.JavaMiniProject.SchoolManagementSystem.model.MedicalInformation;
import com.JavaMiniProject.SchoolManagementSystem.model.ParentGuardian;
import com.JavaMiniProject.SchoolManagementSystem.model.PreviousAcadamicDetail;
import com.JavaMiniProject.SchoolManagementSystem.model.Student;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-10T16:39:36+0000",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class AdmissionMapperImpl implements AdmissionMapper {

    @Override
    public Student toEntity(StudentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.fullName( dto.getFullName() );
        if ( dto.getDateOfBirth() != null ) {
            student.dateOfBirth( Date.from( dto.getDateOfBirth().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }
        student.gender( dto.getGender() );
        student.nationality( dto.getNationality() );
        student.religion( dto.getReligion() );
        student.residentialAddress( addressDTOToAddress( dto.getResidentialAddress() ) );
        student.parentGuardians( toEntity( dto.getParentGuardians() ) );
        student.previousAcadamicDetails( toEntity( dto.getPreviousAcadamicDetails() ) );
        student.admissionDetail( toEntity( dto.getAdmissionDetail() ) );
        student.medicalInformation( medicalInformationDTOToMedicalInformation( dto.getMedicalInformation() ) );

        return student.build();
    }

    @Override
    public StudentDTO toDto(Student entity) {
        if ( entity == null ) {
            return null;
        }

        StudentDTO.StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.fullName( entity.getFullName() );
        if ( entity.getDateOfBirth() != null ) {
            studentDTO.dateOfBirth( LocalDateTime.ofInstant( entity.getDateOfBirth().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        studentDTO.gender( entity.getGender() );
        studentDTO.nationality( entity.getNationality() );
        studentDTO.religion( entity.getReligion() );
        studentDTO.residentialAddress( addressToAddressDTO( entity.getResidentialAddress() ) );
        studentDTO.parentGuardians( toDto( entity.getParentGuardians() ) );
        studentDTO.previousAcadamicDetails( toDto( entity.getPreviousAcadamicDetails() ) );
        studentDTO.admissionDetail( toDTO( entity.getAdmissionDetail() ) );
        studentDTO.medicalInformation( medicalInformationToMedicalInformationDTO( entity.getMedicalInformation() ) );

        return studentDTO.build();
    }

    @Override
    public PreviousAcadamicDetail toEntity(PreviousAcadamicDetailDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PreviousAcadamicDetail previousAcadamicDetail = new PreviousAcadamicDetail();

        previousAcadamicDetail.setLastSchoolAttended( dto.getLastSchoolAttended() );
        previousAcadamicDetail.setLastClassCompleted( dto.getLastClassCompleted() );
        previousAcadamicDetail.setAcadamicPerformanceAttachment( dto.getAcadamicPerformanceAttachment() );

        return previousAcadamicDetail;
    }

    @Override
    public PreviousAcadamicDetailDTO toDto(PreviousAcadamicDetail entity) {
        if ( entity == null ) {
            return null;
        }

        PreviousAcadamicDetailDTO.PreviousAcadamicDetailDTOBuilder previousAcadamicDetailDTO = PreviousAcadamicDetailDTO.builder();

        previousAcadamicDetailDTO.lastSchoolAttended( entity.getLastSchoolAttended() );
        previousAcadamicDetailDTO.lastClassCompleted( entity.getLastClassCompleted() );
        previousAcadamicDetailDTO.acadamicPerformanceAttachment( entity.getAcadamicPerformanceAttachment() );

        return previousAcadamicDetailDTO.build();
    }

    @Override
    public ParentGuardian toEntity(ParentGuardianDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ParentGuardian parentGuardian = new ParentGuardian();

        parentGuardian.setFirstName( dto.getFirstName() );
        parentGuardian.setLastName( dto.getLastName() );
        parentGuardian.setContactNumber( dto.getContactNumber() );
        parentGuardian.setEmailAddress( dto.getEmailAddress() );
        parentGuardian.setOccupation( dto.getOccupation() );

        return parentGuardian;
    }

    @Override
    public ParentGuardianDTO toDto(ParentGuardian entity) {
        if ( entity == null ) {
            return null;
        }

        ParentGuardianDTO.ParentGuardianDTOBuilder parentGuardianDTO = ParentGuardianDTO.builder();

        parentGuardianDTO.firstName( entity.getFirstName() );
        parentGuardianDTO.lastName( entity.getLastName() );
        parentGuardianDTO.contactNumber( entity.getContactNumber() );
        parentGuardianDTO.emailAddress( entity.getEmailAddress() );
        parentGuardianDTO.occupation( entity.getOccupation() );

        return parentGuardianDTO.build();
    }

    @Override
    public AdmissionDetail toEntity(AdmissionDetailDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AdmissionDetail admissionDetail = new AdmissionDetail();

        admissionDetail.setClassForAdmission( dto.getClassForAdmission() );
        admissionDetail.setAcademicYear( dto.getAcademicYear() );
        admissionDetail.setPreferredSecondLanguage( dto.getPreferredSecondLanguage() );
        admissionDetail.setSiblingName( dto.getSiblingName() );
        admissionDetail.setSiblingClass( dto.getSiblingClass() );

        return admissionDetail;
    }

    @Override
    public AdmissionDetailDTO toDTO(AdmissionDetail entity) {
        if ( entity == null ) {
            return null;
        }

        AdmissionDetailDTO.AdmissionDetailDTOBuilder admissionDetailDTO = AdmissionDetailDTO.builder();

        admissionDetailDTO.classForAdmission( entity.getClassForAdmission() );
        admissionDetailDTO.academicYear( entity.getAcademicYear() );
        admissionDetailDTO.preferredSecondLanguage( entity.getPreferredSecondLanguage() );
        admissionDetailDTO.siblingName( entity.getSiblingName() );
        admissionDetailDTO.siblingClass( entity.getSiblingClass() );

        return admissionDetailDTO.build();
    }

    protected Address addressDTOToAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setStreet_name( addressDTO.getStreet_name() );
        address.setHouse_number( addressDTO.getHouse_number() );
        address.setCity( addressDTO.getCity() );
        address.setRegion( addressDTO.getRegion() );
        address.setCountry( addressDTO.getCountry() );

        return address;
    }

    protected MedicalInformation medicalInformationDTOToMedicalInformation(MedicalInformationDTO medicalInformationDTO) {
        if ( medicalInformationDTO == null ) {
            return null;
        }

        MedicalInformation medicalInformation = new MedicalInformation();

        medicalInformation.setBloodType( medicalInformationDTO.getBloodType() );
        medicalInformation.setAllergiesOrConditions( medicalInformationDTO.getAllergiesOrConditions() );
        medicalInformation.setEmergencyContactsName( medicalInformationDTO.getEmergencyContactsName() );
        medicalInformation.setEmergencyContactsNumber( medicalInformationDTO.getEmergencyContactsNumber() );

        return medicalInformation;
    }

    protected AddressDTO addressToAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO.AddressDTOBuilder addressDTO = AddressDTO.builder();

        addressDTO.street_name( address.getStreet_name() );
        addressDTO.house_number( address.getHouse_number() );
        addressDTO.city( address.getCity() );
        addressDTO.region( address.getRegion() );
        addressDTO.country( address.getCountry() );

        return addressDTO.build();
    }

    protected MedicalInformationDTO medicalInformationToMedicalInformationDTO(MedicalInformation medicalInformation) {
        if ( medicalInformation == null ) {
            return null;
        }

        MedicalInformationDTO.MedicalInformationDTOBuilder medicalInformationDTO = MedicalInformationDTO.builder();

        medicalInformationDTO.bloodType( medicalInformation.getBloodType() );
        medicalInformationDTO.allergiesOrConditions( medicalInformation.getAllergiesOrConditions() );
        medicalInformationDTO.emergencyContactsName( medicalInformation.getEmergencyContactsName() );
        medicalInformationDTO.emergencyContactsNumber( medicalInformation.getEmergencyContactsNumber() );

        return medicalInformationDTO.build();
    }
}
