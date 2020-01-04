package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsT23 implements Parcelable {

    private String questionT23;
    private String option1T23;
    private String option2T23;
    private String option3T23;
    private int answerNrT23;


    public QuestionsT23() {
    }

    public QuestionsT23(String questionT23, String option1T23, String option2T23, String option3T23, int answerNrT23) {
        this.questionT23 = questionT23;
        this.option1T23 = option1T23;
        this.option2T23 = option2T23;
        this.option3T23 = option3T23;
        this.answerNrT23 = answerNrT23;
    }

    protected QuestionsT23(Parcel in) {
        questionT23 = in.readString();
        option1T23 = in.readString();
        option2T23 = in.readString();
        option3T23= in.readString();
        answerNrT23 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionT23);
        dest.writeString(option1T23);
        dest.writeString(option2T23);
        dest.writeString(option3T23);
        dest.writeInt(answerNrT23);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionsT23> CREATOR = new Creator<QuestionsT23>() {
        @Override
        public QuestionsT23 createFromParcel(Parcel in) {
            return new QuestionsT23(in);
        }

        @Override
        public QuestionsT23[] newArray(int size) {
            return new QuestionsT23[size];
        }
    };


    public String getQuestionT23() {
        return questionT23;
    }

    public void setQuestionT23(String questionT23) {
        this.questionT23 = questionT23;
    }

    public String getOption1T23() {
        return option1T23;
    }

    public void setOption1T23(String option1T23) {
        this.option1T23 = option1T23;
    }

    public String getOption2T23() {
        return option2T23;
    }

    public void setOption2T23(String option2T23) {
        this.option2T23 = option2T23;
    }

    public String getOption3T23() {
        return option3T23;
    }

    public void setOption3T23(String option3T23) {
        this.option3T23 = option3T23;
    }

    public int getAnswerNrT23() {
        return answerNrT23;
    }

    public void setAnswerNrT23(int answerNrT23) {
        this.answerNrT23 = answerNrT23;
    }
}
