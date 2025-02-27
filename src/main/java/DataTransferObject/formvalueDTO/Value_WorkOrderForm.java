package DataTransferObject.formvalueDTO;

public class Value_WorkOrderForm {
    String orderName,desc,client,status,update_woid;

    public String getUpdate_woid() {
        return update_woid;
    }

    public void setUpdate_woid(String update_woid) {
        this.update_woid = update_woid;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
