package com.example.quiz_app.models;

public class Questions {
    String Description = "";
    String option1 = "";
    String option2 = "";
    String option3 = "";
    String option4= "";
    String correctanswer= "";
    String useranswer = "";

    public Questions(){
    }

    public Questions(String s, String sunbird, String kingfisher, String honey_eater, String hummingbird, String hummingbird1) {
    }

    public String getDescription()
    {
        return Description;
    }
    public void setDescription(String description)
    {
        this.Description=description;
    }
    public String getOption1()
    {
        return option1;
    }
    public void setOption1(String option1)
    {
        this.option1=option1;
    }
    public String getOption2()
    {
        return option2;
    }
    public void setOption2(String option2)
    {
        this.option2=option2;
    }
    public String getOption3()
    {
        return option3;
    }
    public void setOption3(String option3)
    {
        this.option3=option3;
    }
    public String getOption4()
    {
        return option4;
    }
    public void setOption4(String option4)
    {
        this.option4=option4;
    }
    public String getCorrectanswer()
    {
        return correctanswer;
    }
    public void setCorrectanswer(String correctanswer)
    {
        this.correctanswer=correctanswer;
    }
    public String getUseranswer()
    {
        return useranswer;
    }
    public void setUseranswer(String useranswer)
    {
        this.useranswer=useranswer;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "Description='" + Description + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", correctanswer='" + correctanswer + '\'' +
                ", useranswer='" + useranswer + '\'' +
                '}';
    }
}


