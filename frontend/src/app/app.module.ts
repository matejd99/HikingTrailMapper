import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LogInComponent } from './view/log-in/log-in.component';
import { RegisterComponent } from './view/register/register.component';
import { NavigationComponent } from './component/navigation/navigation.component';
import { TrailsComponent } from './view/trails/trails.component';
import { CreateTrailComponent } from './view/create-trail/create-trail.component';
import { TrailItemComponent } from './component/trail-item/trail-item.component';
import { MapComponent } from './component/map/map.component';
import { CommentComponent } from './component/comment/comment.component';

@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
    RegisterComponent,
    NavigationComponent,
    TrailsComponent,
    CreateTrailComponent,
    TrailItemComponent,
    MapComponent,
    CommentComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
