import java.sql.Date;

public class MemberDTO {

	String id;
	String pw;
	String mbr_nm;
	boolean ytn_yn;
	boolean dlt_yn;
	Date reg_dttm;
	Date mod_dttm;
	String mbr_senm;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getMbr_nm() {
		return mbr_nm;
	}
	public void setMbr_nm(String mbr_nm) {
		this.mbr_nm = mbr_nm;
	}
	public boolean isYtn_yn() {
		return ytn_yn;
	}
	public void setYtn_yn(boolean ytn_yn) {
		this.ytn_yn = ytn_yn;
	}
	public boolean isDlt_yn() {
		return dlt_yn;
	}
	public void setDlt_yn(boolean dlt_yn) {
		this.dlt_yn = dlt_yn;
	}
	public Date getReg_dttm() {
		return reg_dttm;
	}
	public void setReg_dttm(Date reg_dttm) {
		this.reg_dttm = reg_dttm;
	}
	public Date getMod_dttm() {
		return mod_dttm;
	}
	public void setMod_dttm(Date mod_dttm) {
		this.mod_dttm = mod_dttm;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", mbr_nm=" + mbr_nm + ", ytn_yn=" + ytn_yn + ", dlt_yn=" + dlt_yn
				+ ", reg_dttm=" + reg_dttm + ", mod_dttm=" + mod_dttm + ", mbr_senm=" + mbr_senm + "]";
	}
	
}


