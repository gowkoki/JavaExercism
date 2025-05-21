class Badge {
    public String print(Integer id, String name, String department) {
        department = department == null ? "OWNER" : department.toUpperCase();
        if(id != null){
            return "["+id+"] - "+name+" - "+department;
        }else{
            return name+" - "+department;
        }
        
    }
}
