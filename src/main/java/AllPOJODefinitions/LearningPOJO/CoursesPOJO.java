package AllPOJODefinitions.LearningPOJO;

import java.util.List;

public class CoursesPOJO {

    private List<WebAutomation> webAutomation;
    private List<APIPojo> api;
    private List<Mobile> mobile;
    public List<WebAutomation> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<WebAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<APIPojo> getApi() {
        return api;
    }

    public void setApi(List<APIPojo> api) {
        this.api = api;
    }

    public List<Mobile> getMobile() {
        return mobile;
    }

    public void setMobile(List<Mobile> mobile) {
        this.mobile = mobile;
    }



}
