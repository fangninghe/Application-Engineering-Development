/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author He_Fangning_001664202
 */
public class PatientInfo {
    private String name;
    private String ID;
    private int age ;
    private String docName;
    private String phaName;
    private VitalSignHistory vsh;
    
    public PatientInfo(){
        vsh = new VitalSignHistory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getPhaName() {
        return phaName;
    }

    public void setPhaName(String phaName) {
        this.phaName = phaName;
    }

    public VitalSignHistory getVsh() {
        return vsh;
    }

    public void setVsh(VitalSignHistory vsh) {
        this.vsh = vsh;
    }
    
    
    
}
