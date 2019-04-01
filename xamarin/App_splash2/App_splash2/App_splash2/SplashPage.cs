using System;
using System.Collections.Generic;
using System.Text;
using Xamarin.Forms;

namespace App_splash2
{
    public class SplashPage : ContentPage
    {
        Image image;

        public SplashPage()
        {
            NavigationPage.SetHasNavigationBar(this, false);

            var sub = new AbsoluteLayout();
            image = new Image
            {
                Source = "kids2.png",
                Aspect = Aspect.AspectFill
                //VerticalOptions = LayoutOptions.CenterAndExpand,
                //HorizontalOptions = LayoutOptions.CenterAndExpand
                //WidthRequest = 100,
                //HeightRequest = 100
            };

            //AbsoluteLayout.SetLayoutFlags(image, AbsoluteLayoutFlags.PositionProportional);
            AbsoluteLayout.SetLayoutFlags(image, AbsoluteLayoutFlags.All);
            //AbsoluteLayout.SetLayoutBounds(image, new Rectangle(0.5, 0.5, AbsoluteLayout.AutoSize, AbsoluteLayout.AutoSize));
            AbsoluteLayout.SetLayoutBounds(image, new Rectangle(0, 0, 1, 1));

            sub.Children.Add(image);

            sub.BackgroundColor = Color.FromHex("#429de3");
            this.Content = sub;

            //return;
        }

        //protected override async void OnAppearing()
        //{
        //    base.OnAppearing();

        //    await image.ScaleTo(1, 2000);
        //    await image.ScaleTo(0.9, 1500, Easing.Linear);
        //    await image.ScaleTo(150, 1200, Easing.Linear);
        //    Application.Current.MainPage = new NavigationPage(new MainPage());
        //}
    }
}
