package com.viettel.qlan.utils;

public class ObjectsValidate {
    //kiểm tra thẻ HTML
    public boolean htmlCheck (String s){
        String regex = "^.*[<>].*$";
            if(s.matches(regex)) {
                return true;
            }
        return false;
    }

    //Kiểm tra tiếng việt co dấu
    public boolean vietNameseCheck (String s){
        String regex = "^.*[Ạ-ỹáàạảãâấầậẩẫăắằặẳẵÁÀẠẢÃÂẤẦẬẨẪĂẮẰẶẲẴéèẹẻẽêếềệểễÉÈẸẺẼÊẾỀỆỂỄóòọỏõôốồộổỗơớờợởỡÓÒỌỎÕÔỐỒỘỔỖƠỚỜỢỞỠúùụủũưứừựửữÚÙỤỦŨƯỨỪỰỬỮíìịỉĩÍÌỊỈĨđĐýỳỵỷỹÝỲỴỶỸ].*$";
        if(s.matches(regex)) {
            return true;
        }
        return false;
    }

    //kiểm tra ký tự đặc biệt
    public boolean specialCharacterCode(String s){
        String regex = "^.*[!@#$%^&*()+\\=\\[\\]{};':\"\\\\|,.<>\\/?-].*$";
        if(s.matches(regex)){
            return true;
        }
        return false;
    }

    public boolean validateNumber(String s){
        String regex = "^.*[a-zA-ZẠ-ỹáàạảãâấầậẩẫăắằặẳẵÁÀẠẢÃÂẤẦẬẨẪĂẮẰẶẲẴéèẹẻẽêếềệểễÉÈẸẺẼÊẾỀỆỂỄóòọỏõôốồộổỗơớờợởỡÓÒỌỎÕÔỐỒỘỔỖƠỚỜỢỞỠúùụủũưứừựửữÚÙỤỦŨƯỨỪỰỬỮíìịỉĩÍÌỊỈĨđĐýỳỵỷỹÝỲỴỶỸ!@#$%^&*()+\\=\\[\\]{};':\"_\\\\|,.<>\\-\\\\/?].*$";
        if (s.matches(regex)){
            return true;
        }else return false;
    }

    public boolean specialUnderscore(String s){
        String regex = "^.*[ ].*$";
        if(s.matches(regex)){
            return true;
        }else return false;
    }

    public boolean lengthCheck(String s, long l){
        if(s.length()>l){
            return true;
        }
        else return false;
    }



}
