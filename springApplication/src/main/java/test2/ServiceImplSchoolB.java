package test2;

public class ServiceImplSchoolB implements Service {
	
	Dao dao;
	
/*	public ServiceImplSchoolB(Dao dao) {
		this.dao = dao;
	}*/
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	

	@Override
	public void addInfo() {
		System.out.println("schoolB의 정보 추가");
		dao.insert();

	}

	@Override
	public void getInfo() {
		System.out.println("schoolB의 정보 검색");
		dao.select();
	}

	@Override
	public void editInfo() {
		System.out.println("schoolB의 정보 수정");
		dao.update();
	}

	@Override
	public void delInfo() {
		System.out.println("schoolB의 정보 삭제");
		dao.delete();
	}

}
