package DataTransferObject.formvalueDTO;

public class Value_IRForm {
    String iR_transdate, iR_dept, iR_irto,iR_wo ,iR_status,update_irid;

    public String getupdate_Irid() {
        return update_irid;
    }

    public void setupdate_Irid(String irid) {
        this.update_irid = irid;
    }

    public String getiR_transdate() {
        return iR_transdate;
    }

    public void setiR_transdate(String iR_transdate) {
        this.iR_transdate = iR_transdate;
    }

    public String getiR_dept() {
        return iR_dept;
    }

    public void setiR_dept(String iR_dept) {
        this.iR_dept = iR_dept;
    }

    public String getiR_irto() {
        return iR_irto;
    }

    public void setiR_irto(String iR_irto) {
        this.iR_irto = iR_irto;
    }

    public String getiR_wo() {
        return iR_wo;
    }

    public void setiR_wo(String iR_wo) {
        this.iR_wo = iR_wo;
    }

    public String getiR_status() {
        return iR_status;
    }

    public void setiR_status(String iR_status) {
        this.iR_status = iR_status;
    }
}
