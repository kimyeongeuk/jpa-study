# GitHub 프로젝트 등록 방법

## 1. 로컬 프로젝트에 Git 초기화

```bash
git init
```

## 2. 원격 GitHub 레포지토리 연결

```bash
git remote add origin https://github.com/kimyeongeuk/jpa-study.git
```

## 3. 프로젝트 파일 Git에 등록

```bash
git add .
```

## 4. 첫 커밋 생성

```bash
git commit -m "first commit"
```

## 5. 브랜치 이름 변경 및 GitHub에 푸시

```bash
git branch -M main
git push -u origin main
```

## 6. 이후 작업 흐름

```bash
git add .
git commit -m "메시지 작성"
git push
```
