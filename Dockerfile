FROM openjdk:12-alpine
COPY ./* /app/
WORKDIR /app/
RUN javac -d ./output ./my/path/MyClass.java
WORKDIR /app/output