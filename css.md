애니메이션 

  @keyframes hideSplashScreen {
    from {
      opacity: 1;
    }
    to {
      opacity: 0;
      visibility: hidden;
      /* visibility:hidden 있어야 애니메이션 사라지고 정상적으로 화면 클릭 등 가능해짐 */
    }
  }
  