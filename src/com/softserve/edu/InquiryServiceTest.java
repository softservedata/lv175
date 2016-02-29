package org.registrator.community.service;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Assert;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.registrator.community.dao.InquiryRepository;
import org.registrator.community.dao.ResourceRepository;
import org.registrator.community.dao.UserRepository;
import org.registrator.community.entity.Inquiry;
import org.registrator.community.entity.Resource;
import org.registrator.community.entity.ResourceType;
import org.registrator.community.entity.Role;
import org.registrator.community.entity.TerritorialCommunity;
import org.registrator.community.entity.Tome;
import org.registrator.community.entity.User;
import org.registrator.community.enumeration.InquiryType;
import org.registrator.community.enumeration.ResourceStatus;
import org.registrator.community.enumeration.RoleType;
import org.registrator.community.enumeration.UserStatus;
import org.registrator.community.service.impl.InquiryServiceImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class InquiryServiceTest {
  UserRepository userRep = mock(UserRepository.class);
  InquiryRepository inqRep = mock(InquiryRepository.class);
  ResourceRepository resRep = mock(ResourceRepository.class);
  InquiryService inqS = new InquiryServiceImpl();
  Date date = new Date();
  
  
  @BeforeMethod
  public void bigBadMethod() throws Exception{
  Class<?> cls = InquiryServiceImpl.class;
	  
	  Field field = cls.getDeclaredField("inquiryRepository");
	  field.setAccessible(true);
	  field.set(inqS, inqRep);
	
	  field = cls.getDeclaredField("userRepository");
	  field.setAccessible(true);
	  field.set(inqS, userRep);
	  
	  field = cls.getDeclaredField("resourceRepository");
	  field.setAccessible(true);
	  field.set(inqS, resRep);
	  
	  field = cls.getDeclaredField("logger");
	  field.setAccessible(true);
	  @SuppressWarnings("unused")
	Logger logger = mock(Logger.class);
  }
  @BeforeClass
  public void prepareUserRepMock(){
	  List<User> mockForUserRep = new ArrayList<User>();
	  
	  when(userRep.count()).then(new Answer<Long>(){
		  public Long answer(InvocationOnMock invocation) throws Throwable{
			  return (long)mockForUserRep.size();
		  }
	  });
	  when(userRep.save((User)anyObject())).then(new Answer<User>(){
		@Override
		public User answer(InvocationOnMock invocation) throws Throwable {
			User givenArg = (User) invocation.getArguments()[0];
			mockForUserRep.add(givenArg);
			return givenArg;
		}
		  
	  });
	  
	  when(userRep.findOne(anyInt())).then(new Answer<User>(){
		 @Override
		 public User answer(InvocationOnMock invocation) throws Throwable{
			 Integer num = invocation.getArgumentAt(0, Integer.class);
			 return mockForUserRep.get(num);
		 }
	  });
	  
	  when(userRep.findUserByLogin(anyString())).then(new Answer<User>(){
		 public User answer(InvocationOnMock invocation) throws Throwable{
			 String userName = invocation.getArgumentAt(0, String.class);
			 for(User usr: mockForUserRep){
				 if(usr.getLogin().equals(userName)){
					 return usr;
				 }
			 }
			 return null;
		 }
	  });
	  doAnswer(new Answer<Void>(){
		 public Void answer(InvocationOnMock invocation) throws Throwable{
			 mockForUserRep.clear();
			 return null;
		 }
	  }).when(userRep).deleteAll();
  }
  
  @BeforeClass
  public void prepareResourceRepMock(){
	  List<Resource> mockForResRep = new ArrayList<Resource>();
	  
	  when(resRep.count()).then(new Answer<Long>(){
		  public Long answer(InvocationOnMock invocation) throws Throwable{
			  return (long)mockForResRep.size();
		  }
	  });
	  when(resRep.findByIdentifier(anyString())).then(new Answer<Resource>(){
		 public Resource answer(InvocationOnMock invocation) throws Throwable{
			 String resource = invocation.getArgumentAt(0, String.class);
			 for(Resource res : mockForResRep){
				 if(res.getIdentifier() == resource)return res;
			 }
			 return null;
		 }
	  });
	  when(resRep.save((Resource)anyObject())).then(new Answer<Resource>(){
		 public Resource answer(InvocationOnMock invocation) throws Throwable{
			 Resource res = invocation.getArgumentAt(0, Resource.class);
			 mockForResRep.add(res);
			 return res;
		 }
	  });
  }
  
  @BeforeClass
  public void prepareInquiryRepMock(){
	  List<Inquiry> mockForInqRep = new ArrayList<Inquiry>();
	  
	  when(inqRep.count()).then(new Answer<Long>(){
		  public Long answer(InvocationOnMock invocation) throws Throwable{
			  return (long)mockForInqRep.size();
		  }
	  });
	  when(inqRep.save((Inquiry)anyObject())).then(new Answer<Inquiry>(){
		 public Inquiry answer(InvocationOnMock invocation) throws Throwable{
			 Inquiry inq = invocation.getArgumentAt(0, Inquiry.class);
			 mockForInqRep.add(inq);
			 return inq;
		 }
	  });
	  when(inqRep.findOne(anyInt())).then(new Answer<Inquiry>(){
		  public Inquiry answer(InvocationOnMock invocation) throws Throwable{
			  Integer num = invocation.getArgumentAt(0, Integer.class);
			  return mockForInqRep.get(num);
		  }
	  });
	  doAnswer(new Answer<Void>(){
		 public Void answer(InvocationOnMock invocation) throws Throwable{
			 mockForInqRep.clear();
			 return null;
		 }
	  }).when(inqRep).deleteAll();
	  
	  when(inqRep.getOne(anyInt())).then(new Answer<Inquiry>(){
		  public Inquiry answer(InvocationOnMock invocation) throws Throwable{
			  Integer num = invocation.getArgumentAt(0, Integer.class);
			  for(Inquiry inq : mockForInqRep){
				  if(inq.getInquiryId().equals(num)){
					  return inq;
				  }
			  }
			  return null;
		  }
	  });
	  doAnswer(new Answer<Void>(){
		  public Void answer(InvocationOnMock invocation) throws Throwable{
			  Integer num = invocation.getArgumentAt(0, Integer.class);
				  for(int i = 0; i< mockForInqRep.size(); i++){
					  Inquiry inq = mockForInqRep.get(i);
					  if(inq.getInquiryId() == num){
							  mockForInqRep.remove(inq);
						  }					
				  }
			  return null;
		  }
	  }).when(inqRep).delete(anyInt());
  }
  @DataProvider(name="ProviderForInquiries")
  public Object[][] formDataForInquiries(){
	  int desiredResources = 10;
	  Object[][] tmp = new Object[desiredResources][3];
	  
	  Role[] roles = new Role[]{new Role(RoleType.REGISTRATOR,"desc"),new Role(RoleType.USER,"desc")};
	  
	  for(int i = 0; i<roles.length; i++){
		  User usr = new User("user."+roles[i].toString().toLowerCase(),"password", roles[i], roles[i].toString(), "is", "User", "m@il.ua", UserStatus.ACTIVE.toString());
		  if(userRep.findUserByLogin("user."+roles[i].toString().toLowerCase()) == null){
			  userRep.save(usr);
		  }
	  }
	  
	  User registrator = userRep.findUserByLogin("user."+RoleType.REGISTRATOR.toString().toLowerCase()),
		   user = userRep.findUserByLogin("user."+RoleType.USER.toString().toLowerCase());
	  String resIdent = "land#",
			 resDef = "This is land";
	  Tome tome = new Tome();
	  ResourceType rt = new ResourceType();
	  
	  for(int i = 0; i< desiredResources; i++){
		  Resource rs = new Resource(rt,resIdent+i, resDef, registrator, date, ResourceStatus.ACTIVE.toString(), tome, "Reason");
		  resRep.save(rs);
	  
		  tmp[i] = new Object[]{registrator, user, rs};
	  }
		  
	  return tmp;
  }
  
  @DataProvider(name="ProviderForListTypeTests")
  public Object[][] forDataForListTypeTests(){
	  int desiredResources = 10;
	  Object[][] tmp = new Object[desiredResources][1];
	  
	  Role[] roles = new Role[]{new Role(RoleType.REGISTRATOR,"desc"),new Role(RoleType.USER,"desc")};
	  TerritorialCommunity tc = new TerritorialCommunity();
	  
	  for(int i = 0; i<roles.length; i++){
		  User usr = new User("user."+roles[i].toString().toLowerCase(),"password", roles[i], roles[i].toString(), "is", "User", "m@il.ua", UserStatus.ACTIVE.toString());
		  if(userRep.findUserByLogin("user."+roles[i].toString().toLowerCase()) == null){
			  usr.setTerritorialCommunity(tc);
			  userRep.save(usr);
		  }else{
			  usr = userRep.findUserByLogin("user."+roles[i].toString().toLowerCase());
			  usr.setTerritorialCommunity(tc);
		  }
		  tmp[i][0] = usr;
	  }
	  
	  return tmp;
  }
  
  @Test(dataProvider="ProviderForListTypeTests")
  public void testForListUserNameFormation(User user){
	  
  }
  
  @Test(dataProvider="ProviderForInquiries")
  public void testForOutputInquiryFormation(User reg, User user, Resource res){
	  Inquiry synthetic = new Inquiry(InquiryType.OUTPUT.toString(),date, user, reg, res),
			  formed = inqS.addOutputInquiry(res.getIdentifier(), reg.getLogin(), user.getLogin());
	  
	  Assert.assertEquals(synthetic.getInquiryType(), formed.getInquiryType());
	  Assert.assertEquals(synthetic.getResource(), formed.getResource());
	  Assert.assertEquals(synthetic.getRegistrator(), formed.getRegistrator());
	  Assert.assertEquals(synthetic.getUser(), formed.getUser());
  }
  
  @AfterMethod
  public void cleanInquiryRepository(){
	  inqRep.deleteAll();
	  System.out.println("Users: "+userRep.count());
  }
  
  @Test(dataProvider="ProviderForInquiries", singleThreaded=true)
  public void testForInputInquiryFormation(User reg, User user, Resource res){
	   long countBefore = inqRep.count() + 1;
	   inqS.addInputInquiry(user.getLogin(), res, reg);
	   Assert.assertEquals(countBefore, inqRep.count());
  }
  
  static int inqId = 0;
  @Test(dataProvider="ProviderForInquiries",singleThreaded=true)
  public void testForRemoveInquiry(User reg, User user, Resource res){
	  Inquiry synthetic = new Inquiry(InquiryType.OUTPUT.toString(),date, user, reg, res);
	  synthetic.setInquiryId(inqId++);
	  inqRep.save(synthetic);

	  synthetic = inqRep.getOne(synthetic.getInquiryId());

	  Assert.assertNotNull(synthetic);
	  
	  inqS.removeInquiry(synthetic.getInquiryId());
	  synthetic = inqRep.getOne(synthetic.getInquiryId());
	  Assert.assertNull(synthetic);
  }
}
