//package com.example.authenticatingldap.service;

//import com.example.authenticatingldap.model.TransmissionRoles;
//import com.example.authenticatingldap.repository.TransmissionRoleRepository;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

//public class TransmissionRolesServiceImpl implements TransmissionRolesService{

  //  private TransmissionRoleRepository transmissionRoleRepository;

  //  public TransmissionRolesServiceImpl(TransmissionRoleRepository transmissionRoleRepository) {
  //      this.transmissionRoleRepository = transmissionRoleRepository;
   // }

   // @Override
  //  public TransmissionRoles findByAdUniqueNumber(String adUniqueNumber) {
  //      System.out.println("Inside by ad unique number");
    //    TransmissionRoles transmissionRoles = transmissionRoleRepository.findByAdUniqueNumber(adUniqueNumber);
   //     if(transmissionRoles == null){
   //         System.out.println("Transmission roles not found");
     //       throw new UsernameNotFoundException("Invalid username or password.");
     //   } else{
     //       return transmissionRoles;
     //   }
  //  }
//}
