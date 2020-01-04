package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsC33 implements Parcelable {


    private String questionC33;
    private String option1C33;
    private String option2C33;
    private String option3C33;
    private int answerNrC33;


    public QuestionsC33() {
    }

    public QuestionsC33(String questionC33, String option1C33, String option2C33, String option3C33, int answerNrC33) {
        this.questionC33 = questionC33;
        this.option1C33 = option1C33;
        this.option2C33 = option2C33;
        this.option3C33 = option3C33;
        this.answerNrC33 = answerNrC33;
    }

    protected QuestionsC33(Parcel in) {
        questionC33 = in.readString();
        option1C33 = in.readString();
        option2C33 = in.readString();
        option3C33= in.readString();
        answerNrC33 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionC33);
        dest.writeString(option1C33);
        dest.writeString(option2C33);
        dest.writeString(option3C33);
        dest.writeInt(answerNrC33);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<QuestionsC33> CREATOR = new Parcelable.Creator<QuestionsC33>() {
        @Override
        public QuestionsC33 createFromParcel(Parcel in) {
            return new QuestionsC33(in);
        }

        @Override
        public QuestionsC33[] newArray(int size) {
            return new QuestionsC33[size];
        }
    };

    public String getQuestionC33() {
        return questionC33;
    }

    public void setQuestionC33(String questionC33) {
        this.questionC33 = questionC33;
    }

    public String getOption1C33() {
        return option1C33;
    }

    public void setOption1C33(String option1C33) {
        this.option1C33 = option1C33;
    }

    public String getOption2C33() {
        return option2C33;
    }

    public void setOption2C33(String option2C33) {
        this.option2C33 = option2C33;
    }

    public String getOption3C33() {
        return option3C33;
    }

    public void setOption3C33(String option3C33) {
        this.option3C33 = option3C33;
    }

    public int getAnswerNrC33() {
        return answerNrC33;
    }

    public void setAnswerNrC33(int answerNrC33) {
        this.answerNrC33 = answerNrC33;
    }
}
