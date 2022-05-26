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
                        <h4 class="user-component__title">경매 알림</h4><i class=" fa-2x" aria-hidden="true" image
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

    <div class="main-screen">
        <div class="user-component">
            <div class="user-component__column">
                <img src="https://static.smalljoys.me/2020/08/2898992_mfwfp-ch_400x400_1597309435.jpg"
                    class="user-component__avatar user-component__avatar">
                <div class="user-component__text">
                    <h4 class="user-component__title">훈이</h4>
                    <h6 class="user-component__subtitle">짱구야 귤 먹으러 올래?</h6>
                </div>
            </div>
            <div class="user-component__column">
               <span class="user-component__time">18:20</span>
                <!-- <div class="badge">3</div> -->
            </div>
        </div>
    </div>

        <a href="chatroom.html">
            <div class="user-component">
                <div class="user-component__column">
                    <img src="https://pbs.twimg.com/profile_images/578040448108752896/oQK7a3gS_400x400.jpeg"
                        class="user-component__avatar user-component__avatar">
                    <div class="user-component__text">
                        <h4 class="user-component__title">철수</h4>
                        <h6 class="user-component__subtitle">숙제는 네가 알아서 해!!</h6>
                    </div>
                </div>
                <div class="user-component__column">
                    <span class="user-component__time">15:30</span>
                </div>
            </div>
        </a>

        <div class="user-component">
            <div class="user-component__column">
                <!-- <img src="../images/123.jpg" class="user-component__avatar user-component__avatar"> -->
                <div class="user-component__text">
                    <h4 class="user-component__title">슘당이</h4>
                    <h6 class="user-component__subtitle">
                        안녕하슘
                    </h6>
                </div>
            </div>
            <div class="user-component__column">
                <span class="user-component__time">13:22</span>
            </div>
        </div>

        <div class="user-component">
            <div class="user-component__column">
                <img src="https://file3.instiz.net/data/file3/2018/01/29/3/3/e/33e755b8a3bf5f282cceeb887dbbd606.jpg"
                    class="user-component__avatar user-component__avatar">
                <div class="user-component__text">
                    <h4 class="user-component__title">유리</h4>
                    <h6 class="user-component__subtitle">내일 봐 짱구야!</h6>
                </div>
            </div>
            <div class="user-component__column">
                <span class="user-component__time">12:54</span>
            </div>
        </div>

    <div id="imageDownloaderSidebarContainer">
        <div class="image-downloader-ext-container">
            <div tabindex="-1" class="b-sidebar-outer">
                <div id="image-downloader-sidebar" tabindex="-1" role="dialog" aria-modal="false" aria-hidden="true"
                    class="b-sidebar shadow b-sidebar-right bg-light text-dark" style="width: 500px; display: none;">
                    <div class="b-sidebar-body">
                        <div></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="main_nav_b_div">
        <nav class="main_b_nav">
            <ul class="main_m_ui_list">
                <li class="nav__btn">
                    <a class="nav__link" href="auction"><h4 class="user-component__title">경매장으로 가기</h4>
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