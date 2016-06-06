package org.reactive.mvc.model;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;

@Table(value = "eorders")
public class Order {

    @PrimaryKey("orderid")
    private String orderid;
    @Column private String last_modified_date;
    
    @Column private String updated;
    @Column private String rolo_url;
    @Column private String order_type;
    @Column private String product;
    @Column private String order_status;
    @Column private String created_date;
    @Column private String received_date;
    @Column private String operator_id;
    @Column private String serviceid;
    @Column private String cease_reason;
    @Column private String committed_date;
    @Column private String bt_service_id;
    @Column private String last_created_date;
    @Column private String service_url;
    @Column private String directory_number;
    @Column private String type;
    @Column private String last_supplier_message;
    @Column private String last_supplier_code;
    @Column private String last_supplier_message_url_notification;

    public String getLast_supplier_message_url_notification() {
        return last_supplier_message_url_notification;
    }

    public void setLast_supplier_message_url_notification(String last_supplier_message_url_notification) {
        this.last_supplier_message_url_notification = last_supplier_message_url_notification;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getRolo_url() {
        return rolo_url;
    }

    public void setRolo_url(String rolo_url) {
        this.rolo_url = rolo_url;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(String last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getReceived_date() {
        return received_date;
    }

    public void setReceived_date(String received_date) {
        this.received_date = received_date;
    }

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public String getCease_reason() {
        return cease_reason;
    }

    public void setCease_reason(String cease_reason) {
        this.cease_reason = cease_reason;
    }

    public String getCommitted_date() {
        return committed_date;
    }

    public void setCommitted_date(String committed_date) {
        this.committed_date = committed_date;
    }

    public String getBt_service_id() {
        return bt_service_id;
    }

    public void setBt_service_id(String bt_service_id) {
        this.bt_service_id = bt_service_id;
    }

    public String getLast_created_date() {
        return last_created_date;
    }

    public void setLast_created_date(String last_created_date) {
        this.last_created_date = last_created_date;
    }

    public String getService_url() {
        return service_url;
    }

    public void setService_url(String service_url) {
        this.service_url = service_url;
    }

    public String getDirectory_number() {
        return directory_number;
    }

    public void setDirectory_number(String directory_number) {
        this.directory_number = directory_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLast_supplier_message() {
        return last_supplier_message;
    }

    public void setLast_supplier_message(String last_supplier_message) {
        this.last_supplier_message = last_supplier_message;
    }

    public String getLast_supplier_code() {
        return last_supplier_code;
    }

    public void setLast_supplier_code(String last_supplier_code) {
        this.last_supplier_code = last_supplier_code;
    }
}
