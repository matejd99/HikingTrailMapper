import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from './service/auth-guard-service.service';
import { CreateTrailComponent } from './view/create-trail/create-trail.component';
import { LogInComponent } from './view/log-in/log-in.component';
import { RegisterComponent } from './view/register/register.component';
import { TrailsComponent } from './view/trails/trails.component';

const routes: Routes = [
  {
    path: 'log-in',
    component: LogInComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: 'create-trail',
    component: CreateTrailComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'update-trail',
    component: CreateTrailComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: '',
    pathMatch: 'full',
    component: TrailsComponent,
    canActivate: [AuthGuardService],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
