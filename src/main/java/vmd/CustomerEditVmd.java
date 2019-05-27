package vmd;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Include;
import org.zkoss.zul.Messagebox;

import service.MstCustomerService;
import service.MstCustomerService;
import service.MstDepartmentService;
import dao.MstCustomerDao;
import dao.MstDepartmentDao;
import dto.MstCustomerDto;
import dto.MstDepartmentDto;
import entity.MstDepartment;
import dto.MstKaryawanDto;
import entity.MstCustomer;
import entity.enumcol.GenderEnum;
import entity.pk.MstDepartmentPk;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CustomerEditVmd {

	@WireVariable
	private MstCustomerService mstCustomerSvc;
	
	@WireVariable
	private MstDepartmentService mstDepartmentSvc;
	
	@WireVariable
	private MstDepartmentDao mstDepartmentDao;
	
	private MstDepartment mstDepartment;
	
	private MstCustomerDto mstCustomerDto = new MstCustomerDto();
	private GenderEnum gender;
	private List<MstCustomerDto> listCustomer = new ArrayList<MstCustomerDto>();
	private MstDepartmentDto mstDepartmentDto;
	
	private String genderChoice;

	@Init
	@NotifyChange(value={"genderChoice"})
	public void load(){
		mstCustomerDto = (MstCustomerDto) Sessions.getCurrent().getAttribute("objCustomer");
		genderChoice = mstCustomerDto.getGender() != null ? mstCustomerDto.getGender().getCode() : "";
//		getAllDepartment();
	}
	
	@Command(value="save")
	public void save(){
		MstCustomerDto mstCustomerFindOne = new MstCustomerDto();
		mstCustomerFindOne = mstCustomerSvc.findOne(mstCustomerDto);
		
		if(mstCustomerFindOne != null && mstCustomerFindOne.getId() != null){
			MstDepartmentPk deptPk = new MstDepartmentPk();
			deptPk.setId(mstDepartmentDto.getId());
			mstDepartment = mstDepartmentDao.findOne(deptPk);
			
			mstCustomerDto.setDepartment(mstDepartment);
			gender = genderChoice.equalsIgnoreCase("M")? GenderEnum.MALE : GenderEnum.FEMALE;
			mstCustomerDto.setGender(gender);
			mstCustomerSvc.update(mstCustomerDto);
			Clients.showNotification("Data berhasil diupdate", Clients.NOTIFICATION_TYPE_INFO, null, null, 1500);
			Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
			inc.setSrc("/master/customer/customer.zul");
		}
		else{
			mstCustomerSvc.save(mstCustomerDto);
			Clients.showNotification("Data berhasil disimpan", Clients.NOTIFICATION_TYPE_INFO, null, null, 1500);
			Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
			inc.setSrc("/master/customer/customer.zul");
		}
	}
	
	@Command(value="back")
	public void back(){
		Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
		inc.setSrc("/master/customer/customer.zul");
	}
	
//	private void getAllDepartment(){
//	if(mstDepartmentSvc.findAllNotDeleted() != null 
//			&& !mstDepartmentSvc.findAllNotDeleted().isEmpty()
//			&& mstDepartmentSvc.findAllNotDeleted().size() > 0){
//		listDepartment = mstDepartmentSvc.findAllNotDeleted();
//	}
//	else{
//		Messagebox.show("Tidak ada daftar Department yang bisa ditampilkan");
//	}
//}


	public MstCustomerService getMstCustomerSvc() {
		return mstCustomerSvc;
	}

	public void setMstCustomerSvc(MstCustomerService mstCustomerSvc) {
		this.mstCustomerSvc = mstCustomerSvc;
	}


	public MstCustomerDto getMstCustomerDto() {
		return mstCustomerDto;
	}

	public void setMstCustomerDto(MstCustomerDto mstCustomerDto) {
		this.mstCustomerDto = mstCustomerDto;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public List<MstCustomerDto> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<MstCustomerDto> listCustomer) {
		this.listCustomer = listCustomer;
	}

	public String getGenderChoice() {
		return genderChoice;
	}

	public void setGenderChoice(String genderChoice) {
		this.genderChoice = genderChoice;
	}

	public MstDepartmentService getMstDepartmentSvc() {
		return mstDepartmentSvc;
	}

	public void setMstDepartmentSvc(MstDepartmentService mstDepartmentSvc) {
		this.mstDepartmentSvc = mstDepartmentSvc;
	}

	public MstDepartmentDao getMstDepartmentDao() {
		return mstDepartmentDao;
	}

	public void setMstDepartmentDao(MstDepartmentDao mstDepartmentDao) {
		this.mstDepartmentDao = mstDepartmentDao;
	}

	public MstDepartment getMstDepartment() {
		return mstDepartment;
	}

	public void setMstDepartment(MstDepartment mstDepartment) {
		this.mstDepartment = mstDepartment;
	}

	public MstDepartmentDto getMstDepartmentDto() {
		return mstDepartmentDto;
	}

	public void setMstDepartmentDto(MstDepartmentDto mstDepartmentDto) {
		this.mstDepartmentDto = mstDepartmentDto;
	}
	
}
