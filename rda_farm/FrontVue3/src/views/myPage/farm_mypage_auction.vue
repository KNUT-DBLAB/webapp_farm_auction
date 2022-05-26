<template>
<div>
    <div class="main_nav_t_div">
        <nav class="main_t_nav">
            <ul class="main_t_nav_list">
                <li class="nav__btn">
                    <div class="nav__notification-dot"></div>
                    <a class="nav__link"><i class="fas fa-bars fa-2x" aria-hidden="true"></i>
                    </a>
                </li>
    
                
                <li class="main_m_li_list">
                    <a class="nav_m_link" href="workout.html">
                        <h4 class="user-component__title">경매내역</h4><i class=" fa-2x" aria-hidden="true" image
                            src="../image/123.jpg"></i>
                    </a>
                </li>
                <li class="nav__btn">
                    <a class="nav__link" onclick="goBack()"><i class="fas fa-chevron-left fa-2x"
                            aria-hidden="true"></i>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

<fieldset>
    <table class="table table-striped table-bordered table-hover">
        <!-- <caption>테이블 설명</caption> -->
        <thead>
                <tr class="success">
                <th>날짜</th>
                <th>작물명</th>
                <th>현재 경매가</th>
                <th>최종 낙찰가</th>
                <th>상태</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>9/16</td>
                <td>못난이 복숭아</td>
                <td>10,000</td>
                <td>-</td>
                <td>시간(진행중)</td>
            </tr>
            <tr>
                <td>2</td>
                <td>데이터2</td>
                <td>데이터3</td>
                <td>데이터4</td>
                <td>정산하기(마감)</td>
            </tr>
            <tr>
                <td>3</td>
                <td>데이터2</td>
                <td>데이터3</td>
                <td>데이터4</td>
                <td>데이터5</td>
            </tr>
            <tr>
                <td>4</td>
                <td>데이터2</td>
                <td>데이터3</td>
                <td>데이터4</td>
                <td>데이터5</td>
            </tr>
            <tr>
                <td>5</td>
                <td>데이터2</td>
                <td>데이터3</td>
                <td>데이터4</td>
                <td>데이터5</td>
            </tr>
        </tbody>
    </table>
  </fieldset>

<div class="main_nav_b_div">
    <nav class="main_b_nav">
        <ul class="main_m_ui_list">
            <li class="nav__btn">
                <a class="nav__link" href="#"><h4 class="user-component__title">등록하기</h4>
                </a>
            </li>
        </ul>
    </nav>
</div>

</div>
</template>


<script>

</script>

<style>

</style>