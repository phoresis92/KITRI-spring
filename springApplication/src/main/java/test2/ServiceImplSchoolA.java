package test2;

public class ServiceImplSchoolA implements Service {
	
	Dao dao;
	
/*	public ServiceImplSchoolA(Dao dao) {
		this.dao = dao;
	}*/
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	

	@Override
	public void addInfo() {
		System.out.println("schoolA의 정보 추가");
		dao.insert();

	}

	@Override
	public void getInfo() {
		System.out.println("schoolA의 정보 검색");
		dao.select();
	}

	@Override
	public void editInfo() {
		System.out.println("schoolA의 정보 수정");
		dao.update();
	}

	@Override
	public void delInfo() {
		System.out.println("schoolA의 정보 삭제");
		dao.delete();
	}

}
